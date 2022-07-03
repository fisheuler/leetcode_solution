//Given a string containing just the characters '(' and ')', find the length of 
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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        int max = 0;
        int currentLength=0;
        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(ch==")"){
                if(stack.size()>0){
                    if (stack.top() == ")"){
                        max = Math.max(max,currentLength);
                        currentLength=0;
                        stack.push(ch);
                    }else{
                        currentLength+=2;
                        stack.pop();
                    }
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
