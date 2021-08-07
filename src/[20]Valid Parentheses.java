//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 8397 👎 340


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_20 {
    public boolean isValid(String s) {
        if(s==null || s.length()%2==1){
            return false;
        }


        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.size()<1){
                    return false;
                }
                char stackTop = stack.peek();
                if(ch==')' && stackTop=='(' || ch=='}' && stackTop=='{' ||
                ch==']' && stackTop=='['){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.size()>0){
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
