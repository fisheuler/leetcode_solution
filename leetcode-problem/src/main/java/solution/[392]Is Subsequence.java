package solution;//Given two strings s and t, return true if s is a subsequence of t, or false ot
//herwise. 
//
// A subsequence of a string is a new string that is formed from the original st
//ring by deleting some (can be none) of the characters without disturbing the rel
//ative positions of the remaining characters. (i.e., "ace" is a subsequence of "a
//bcde" while "aec" is not). 
//
// 
// Example 1: 
// Input: s = "abc", t = "ahbgdc"
//Output: true
// Example 2: 
// Input: s = "axc", t = "ahbgdc"
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 104 
// s and t consist only of lowercase English letters. 
// 
//
// 
//Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >
//= 109, and you want to check one by one to see if t has its subsequence. In this
// scenario, how would you change your code? Related Topics Two Pointers String Dy
//namic Programming 
// 👍 4082 👎 271


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_392 {
    public boolean isSubsequence(String s, String t) {
        if( s.length() > t.length()){
            return false;
        }
        if(s.length()<=0){
            return true;
        }

        int i = 0;
        int k = 0;
        boolean is = false;
        for(;i<s.length();i++){
            char ch = s.charAt(i);

            while(k<t.length()){
                if(t.charAt(k) == ch){
                    if(i == (s.length()-1)){
                        is = true;
                    }
                    k++;
                    break;
                }else{
                    k++;
                }
            }
        }

        return is;
    }


    public static void main(String[] args){
        Solution_392 solution = new Solution_392();


//        String  s = "aaaaaa", t = "bbaaaa";

        String  s = "axc", t = "ahbgdc";
        System.out.println(solution.isSubsequence(s,t));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
