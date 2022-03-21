//Given a balanced parentheses string s, return the score of the string. 
//
// The score of a balanced parentheses string is based on the following rule: 
//
// 
// "()" has score 1. 
// AB has score A + B, where A and B are balanced parentheses strings. 
// (A) has score 2 * A, where A is a balanced parentheses string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: s = "(())"
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: s = "()()"
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 2 <= s.length <= 50 
// s consists of only '(' and ')'. 
// s is a balanced parentheses string. 
// 
// Related Topics String Stack 
// 👍 3225 👎 95


import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Character> stack = new ArrayDeque<>();

        int score = 0;
        for(int i=0;i<s.length();i++){
            if(s.length()=='('){
                stack.push('(');
            }else{
                if(stack.size()>0){
                    score += Math.pow(2,stak.size()-1);
                    stack.clear();
                }
            }
        }

        return score;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
