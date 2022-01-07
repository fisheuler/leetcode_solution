package solution;//Given a string s, partition s such that every substring of the partition is a
//palindrome. Return all possible palindrome partitioning of s. 
//
// A palindrome string is a string that reads the same backward as forward. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 5100 👎 155


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_131 {
    /*

    https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java%3A-Backtracking-solution

    用递归 算法

     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s==null || s.length() == 0){
            List<String> sub = new ArrayList<>();
            result.add(sub);
        }
        if(s.length()==1){
            List<String> sub = new ArrayList<>();
            sub.add(s);
            result.add(sub);
            return result;
        }

        for(int i = 1; i<=s.length();i++){
            if(isPalindrome(s.substring(0,i))){
                List<List<String>> subResult = partition(s.substring(i));
                for(List<String> sub: subResult){
                    sub.add(0,s.substring(0,i));
                    result.add(sub);
                }

            }
        }

        return result;
    }



    public static boolean isPalindrome(String s){
        if(s==null || s.length()==0){
            return false;
        }

        if( s.length()==1){
            return true;
        }

        for(int i=0;i<s.length()/2;i++){
            if(!(s.charAt(i)==s.charAt(s.length()-i-1))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Solution_131 solution_10 = new Solution_131();
        System.out.println(solution_10.partition("bb"));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
