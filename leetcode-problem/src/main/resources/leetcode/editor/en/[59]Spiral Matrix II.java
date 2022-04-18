//Given a positive integer n, generate an n x n matrix filled with elements from
// 1 to n2 in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics Array Matrix Simulation 
// 👍 3050 👎 168


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rStart = 0,rEnd = n-1;
        int cStart = 0,cEnd = n-1;
                c = n-1,;
        int i =1;

        while(rStart<=rEnd && cStart<=cEnd){
            //填一行
            for(int k = cStart;k<cEnd;k++){
                matrix[rStart][k] = i++;
            }
            //填一列
            for(int k = rStart+1;k<rEnd;k++){
                matrix[k][rEnd]=i++;
            }
            // 倒序填写行
            for( int k=cEnd-1;k>=cStart;k--){
                matrix[rEnd][k]=i++;
            }

            // 倒序填写列
            for(int k=rEnd-1;k>=rStart-1;k--){
                matrix[k][cStart]=i++;
            }
            rStart +=1;
            rEnd -=1;
            cStart+=1;
            cEnd -=1;
        }

        return matrix;
    }


















}
//leetcode submit region end(Prohibit modification and deletion)
