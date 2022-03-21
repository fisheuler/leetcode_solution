package solution;//Given a string s, remove duplicate letters so that every letter appears once a
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
class Solution_316 {
    public String removeDuplicateLetters(String s) {
        int[] num = new int[26];
        boolean[] visited = new boolean[26];
        for(char ch: s.toCharArray()){
            num[ch-'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){

            int index = ch-'a';
            num[index]--;

            if(visited[index]){
                continue;
            }

            while(!stack.isEmpty() && (stack.peek()>ch) && num[stack.peek()-'a']>0){
                visited[stack.peek()-'a']=false;
                stack.pop();
            }

            stack.push(ch);
            visited[ch-'a']=true;

        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Solution_316 solution = new Solution_316();

        String s = "cbacdcbc";

        System.out.println(solution.removeDuplicateLetters(s));
    }



}
//leetcode submit region end(Prohibit modification and deletion)
