//Given a string s of '(' , ')' and lowercase English characters. 
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any
// positions ) so that the resulting parentheses string is valid and return any va
//lid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid stri
//ngs, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s[i] is either'(' , ')', or lowercase English letter. 
// 
// Related Topics String Stack 
// 👍 3743 👎 69


import java.util.HashSet;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class CharPosition{
        public char ch;
        public int position;
    }

    public String minRemoveToMakeValid(String s) {

        Set<Integer> deleted = new HashSet<>();
        Stack<CharPosition> stack = new Stack<CharPosition>()
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(new CharPosition(ch,i));
            }else if (ch == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    deleted.add(i);
                }
            }
        }

        while(stack.size()>0){
            deleted.add(stack.pop().position);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!deleted.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
