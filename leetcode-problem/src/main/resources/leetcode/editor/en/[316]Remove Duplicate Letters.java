//Given a string s, remove duplicate letters so that every letter appears once a
//nd only once. You must make sure your result is the smallest in lexicographical 
//order among all possible results. 
//
// 
// Example 1: 
//
// 
//Input: s = "bcabc"
//Output: "abc"
// 
//
// Example 2: 
//
// 
//Input: s = "cbacdcbc"
//Output: "acdb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of lowercase English letters. 
// 
//
// 
// Note: This question is the same as 1081: https://leetcode.com/problems/smalle
//st-subsequence-of-distinct-characters/ 
// Related Topics String Stack Greedy Monotonic Stack 
// 👍 4396 👎 296


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] num = new int[];
        for(char ch: s.toCharArray()){
            num[ch-'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){

            int left = num[ch-'a']--;

            if(left <= 0){
                stack.push(ch);
            }else{
                while(!stack.isEmpty() && (stack.peek()>ch) && num[stack.peek()]>0){
                    stack.pop();
                }
                stack.push(ch);
            }

        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }

        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
