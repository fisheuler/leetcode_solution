//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order o
//f the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both s
//trings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
// Related Topics String Dynamic Programming 
// 👍 3839 👎 44


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*

    int lcs[i][j] 标识 test1[i]和test2[j]字符串的最长递增子序列


    递推公式

    lcs[i][j] :


    1 如果test1[i]和test2[j] 相等

    lcs[i][j] = lcs[i-1][j-1]+1

    2 如果tet[i]和test2[j]不相等
    lcs[i][j] = max(lcs[i-1][j] ,lcs[i][j-1])



     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] lcs = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            lcs[i][0]=0;
        }

        for(int j=0;j<=n;j++){
            lcs[0][j] = 0;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    lcs[i+1][j+1] = lcs[i][j]+1;
                }else{
                    int max = Math.max(lcs[i+1][j],lcs[i][j+1]);
                    lcs[i+1][j+1] = max;
                }

            }
        }

        return lcs[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
