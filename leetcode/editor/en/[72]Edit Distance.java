//Given two strings word1 and word2, return the minimum number of operations req
//uired to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 6295 👎 74


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*

        https://leetcode.com/problems/edit-distance/discuss/25846/C%2B%2B-O(n)-space-DP

        cost[i][j]: minimum operations to convert word1 to word2


        transform formula:

        1 word[i]=word[j]
        : cost[i][j]=cost[i-1][j-1]

        2 word[i] != word[j]

        2.1 delete操作 cost[i-1][j] +delete word1的第i个字符
        2.2 add 操作   cost[i][j-1] +add  word2的第j个字符
        2.3 replace操作 cost[i-1][j-1] 将word1的第i个字符转换成word2的第j个字符


     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            cost[i][0]=i;
        }

        for(int j=0;j<=n;j++){
            cost[0][j] = j;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word1.charAt(i) == word1.charAt(j)){
                    cost[i+1][j+1] = cost[i][j];
                }else{
                    int a = cost[i][j]; // replace
                    int b = cost[i+1][j]; // add
                    int c = cost[i][j+1]; // delete
                    int max = Math.max(a,Math.max(b,c));
                    cost[i+1][j+1] = max ++;
                }

            }
        }

        return cost[m][n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
