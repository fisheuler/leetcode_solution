//Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of 
//s1 and s2. 
//
// An interleaving of two strings s and t is a configuration where they are divi
//ded into non-empty substrings such that: 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + 
//t3 + s3 + ... 
// 
//
// Note: a + b is the concatenation of strings a and b. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: s1 = "", s2 = "", s3 = ""
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1, s2, and s3 consist of lowercase English letters. 
// 
//
// 
// Follow up: Could you solve it using only O(s2.length) additional memory space
//? 
// Related Topics String Dynamic Programming 
// 👍 2971 👎 158


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    用动态规划

    m[i][j] 是否是 s1的前i个字母和s2的前j个字母的较差排序

    0 -----i  s1

    0 -----j  s2

    m[0][0] = true
    递推公式

    m[i][j]:

    m[i-1][j] && s3[i+j+1] == s1[i]

    m[i][j-1] && s3[i+j+1] == s2[j]



     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != (s1.length() + s2.length())){
            return false;
        }

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] =true;
        for(int i=0;i<=s1.length();i++){
            for( int j = 0 ;j<=s2.length();j++){
                if(i==0 && j==0){
                    //空字符串也占据一个字符位置
                    dp[i][j]=true;
                }else if ( i==0){
                    /*
                        注意字符串的小标操作，由于dp矩阵初始化的时候，dp的 i=0和j=0两个位置
                        分别代表是空字符串下的dp组合，所以后续下表迭代的时候，s3的下表需要减去2，
                        s1或者s2的下标要减去1
                     */
                    dp[i][j] = dp[i][j-1] && s3.charAt(i+j+1-2) == s2.charAt(j-1);
                }else if (j==0){
                    dp[i][j] = dp[i-1][j] && s3.charAt(i+j+1-2) == s1.charAt(i-1);
                }else {
                    dp[i][j] = (dp[i][j-1] && s3.charAt(i+j+1-2) == s2.charAt(j-1))
                            || (dp[i-1][j] && s3.charAt(i+j+1-2) == s1.charAt(i-1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
