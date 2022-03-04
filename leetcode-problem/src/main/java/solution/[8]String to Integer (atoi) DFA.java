package solution;//Implement the myAtoi(string s) function, which converts a string to a 32-bit s
//igned integer (similar to C/C++'s atoi function). 
//
// The algorithm for myAtoi(string s) is as follows: 
//
// 
// Read in and ignore any leading whitespace. 
// Check if the next character (if not already at the end of the string) is '-' 
//or '+'. Read this character in if it is either. This determines if the final res
//ult is negative or positive respectively. Assume the result is positive if neith
//er is present. 
// Read in next the characters until the next non-digit character or the end of 
//the input is reached. The rest of the string is ignored. 
// Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no
// digits were read, then the integer is 0. Change the sign as necessary (from ste
//p 2). 
// If the integer is out of the 32-bit signed integer range [-231, 231 - 1], the
//n clamp the integer so that it remains in the range. Specifically, integers less
// than -231 should be clamped to -231, and integers greater than 231 - 1 should b
//e clamped to 231 - 1. 
// Return the integer as the final result. 
// 
//
// Note: 
//
// 
// Only the space character ' ' is considered a whitespace character. 
// Do not ignore any characters other than the leading whitespace or the rest of
// the string after the digits. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "42"
//Output: 42
//Explanation: The underlined characters are what is read in, the caret is the c
//urrent reader position.
//Step 1: "42" (no characters read because there is no leading whitespace)
//         ^
//Step 2: "42" (no characters read because there is neither a '-' nor '+')
//         ^
//Step 3: "42" ("42" is read in)
//           ^
//The parsed integer is 42.
//Since 42 is in the range [-231, 231 - 1], the final result is 42.
// 
//
// Example 2: 
//
// 
//Input: s = "   -42"
//Output: -42
//Explanation:
//Step 1: "   -42" (leading whitespace is read and ignored)
//            ^
//Step 2: "   -42" ('-' is read, so the result should be negative)
//             ^
//Step 3: "   -42" ("42" is read in)
//               ^
//The parsed integer is -42.
//Since -42 is in the range [-231, 231 - 1], the final result is -42.
// 
//
// Example 3: 
//
// 
//Input: s = "4193 with words"
//Output: 4193
//Explanation:
//Step 1: "4193 with words" (no characters read because there is no leading whit
//espace)
//         ^
//Step 2: "4193 with words" (no characters read because there is neither a '-' n
//or '+')
//         ^
//Step 3: "4193 with words" ("4193" is read in; reading stops because the next c
//haracter is a non-digit)
//             ^
//The parsed integer is 4193.
//Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 200 
// s consists of English letters (lower-case and upper-case), digits (0-9), ' ',
// '+', '-', and '.'. 
// 
// Related Topics String 
// 👍 984 👎 2878


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_DFA {

    /*

    https://leetcode.com/problems/string-to-integer-atoi/solution/

     */

    enum State { q0, q1, q2, qd }

    class StateMachine {
        // Store current state value.
        private State currentState;
        // Store result formed and it's sign.
        private int result, sign;

        public StateMachine() {
            currentState = State.q0;
            result = 0;
            sign = 1;
        }

        // Transition to state q1.
        private void toStateQ1(char ch) {
            sign = (ch == '-') ? -1 : 1;
            currentState = State.q1;
        }

        // Transition to state q2.
        private void toStateQ2(int digit) {
            currentState = State.q2;
            appendDigit(digit);
        }

        // Transition to dead state qd.
        private void toStateQd() {
            currentState = State.qd;
        }

        // Append digit to result, if out of range return clamped value.
        private void appendDigit(int digit) {
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                if (sign == 1) {
                    // If sign is 1, clamp result to Integer.MAX_VALUE.
                    result = Integer.MAX_VALUE;
                } else {
                    // If sign is -1, clamp result to Integer.MIN_VALUE.
                    result = Integer.MIN_VALUE;
                    sign = 1;
                }

                // When the 32-bit int range is exceeded, a dead state is reached.
                toStateQd();
            } else {
                // Append current digit to the result.
                result = result * 10 + digit;
            }
        }

        // Change state based on current input character.
        public void transition(char ch) {
            if (currentState == State.q0) {
                // Beginning state of the string (or some whitespaces are skipped).
                if (ch == ' ') {
                    // Current character is a whitespaces.
                    // We stay in same state.
                    return;
                } else if (ch == '-' || ch == '+') {
                    // Current character is a sign.
                    toStateQ1(ch);
                } else if (Character.isDigit(ch)) {
                    // Current character is a digit.
                    toStateQ2(ch - '0');
                } else {
                    // Current character is not a space/sign/digit.
                    // Reached a dead state.
                    toStateQd();
                }
            } else if (currentState == State.q1 || currentState == State.q2) {
                // Previous character was a sign or digit.
                if (Character.isDigit(ch)) {
                    // Current character is a digit.
                    toStateQ2(ch - '0');
                } else {
                    // Current character is not a digit.
                    // Reached a dead state.
                    toStateQd();
                }
            }
        }

        // Return the final result formed with it's sign.
        public int getInteger() {
            return sign * result;
        }

        // Get current state.
        public State getState() {
            return currentState;
        }
    };

    class Solution {
        public int myAtoi(String s) {
            StateMachine Q = new StateMachine();

            for (int i = 0; i < s.length() && Q.getState() != State.qd; ++i) {
                Q.transition(s.charAt(i));
            }

            return Q.getInteger();
        }
    }



    public static void main(String[] args){
        Solution_8 solution = new Solution_8();
        String[] testCase = new String[]{"+-12","42",".1","4193 with words","-91283472332",
                "00000-42a1234","   -42","-000000000000001"};
        for(String test:testCase){
            System.out.println("Original:\t"+test + "\t\tconvert:\t"+solution.myAtoi(test));
        }

        System.out.println(solution.myAtoi("-000000000000001"));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
