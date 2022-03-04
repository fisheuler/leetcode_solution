package solution;//Given two strings s1 and s2, return true if s2 contains a permutation of s1, o
//r false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of s
//2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 4844 👎 131


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int[] s1Freq = new int[26];
        for(char ch: s1.toCharArray()){
            s1Freq[ch-'a']++;
        }

        int[] s2Freq = new int[26];

        int i=0;
        for(;i<s1.length();i++){
            s2Freq[s2.charAt(i)-'a']++;
        }
        if(isSame(s1Freq,s2Freq)){
            return true;
        }
        for(;i<s2.length();i++){
            s2Freq[s2.charAt(i)-'a']++;
            s2Freq[s2.charAt(i-s1.length())-'a']--;
            if(isSame(s1Freq,s2Freq)){
                return true;
            }
        }
        return false;
    }

    public boolean isSame(int[] s1 ,int[] s2){
        for(int i =0;i<s1.length;i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        Solution_567 solution = new Solution_567();

        String s1 = "ab", s2 = "eidbaooo";

        System.out.println(solution.checkInclusion(s1,s2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
