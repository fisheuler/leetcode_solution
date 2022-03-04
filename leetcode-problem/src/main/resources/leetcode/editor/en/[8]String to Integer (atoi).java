//Implement the myAtoi(string s) function, which converts a string to a 32-bit s
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
class Solution {
    /*

    bad case
    1  "-91283472332"


     */
    public int myAtoi(String s) {
        if( s == null || s.length() == 0){
            return 0;
        }

        int sign = 1;
        int value = 0;
        //wheather find the first valid character
        boolean find = false;

        int i = 0;
        for(;i<s.length();i++){
            char ch = s.charAt(i);
            // skip the empty character
            if(ch ==' '){
                continue;
            }
        }

        for(;i<s.length();i++){
            if (ch == '+' || ch == '-'){
                // find the sign character
                sign = ch == '+'?1:-1;
            }else if ( ch >'9' || ch <'0'){
                // skip the invalid character
                break;
            }else {
                // overstep the boundary check
                if( overBoundryCheck(value,sign,ch-'0')){
                    return sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }else{
                    value = value*10 + ch -'0';
                }
            }
        }
        return value*sign;
    }

    public boolean overBoundryCheck(int current,int sign,int toAdd){
        if(sign == 1){
            /*
                current *10 + toAdd > Integer.MAX_VALUE
                =>
                current > (Integer.Max_Value - toAdd)/10

             */
            if(current>(Integer.MAX_VALUE-toAdd)/10){
                return true;
            }
        }else{
            /*
                (current*10 + toAdd) * (-1) < Integer.MIN_VALUE

                =>

                current*10 + toAdd > Integer.MIN_VALUE*(-1)

                =>
                current > (Integer.MIN_VALUE*(-1)-toAdd)/10
             */
            if(current > (Integer.MAX_VALUE*(-1)-toAdd)/10){
                return true;
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
