package solution;//Given a string containing just the characters '(' and ')', find the length of
//the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] is '(', or ')'. 
// 
// Related Topics String Dynamic Programming Stack 
// 👍 7887 👎 265


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();

                if(stack.empty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i-stack.peek());
                }
            }

        }
        return max;
    }

    public static void main(String[] args){
        Solution_32 solution = new Solution_32();
        int[] nums = new int[]{5,1,1};
        /*

                "(()"

                ")()())"

         */

        String s ="()(()())";


//        String s = "(()";
        System.out.println(solution.longestValidParentheses(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
