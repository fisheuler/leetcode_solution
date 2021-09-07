//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 
// 👍 4439 👎 692


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<Integer> result = new ArrayList();
    public List<Integer> spiralOrder(int[][] matrix) {
        int width = matrix.length;
        int length =matrix[0].length;

        iterate(matrix,0,0,width-1,length-1);
        return result;
    }

    public void iterate(int[][] matrix,int i, int j,int m,int n){
        if(i>m || j>n){
            return;
        }
        for(int k=j;k<=n;k++){
            result.add(matrix[i][k]);
        }
        for(int k=i+1;k<=m;k++){
            result.add(matrix[k][n]);
        }
        // 防止重复打印
        if(i<m && j<n){
            for(int k=n-1;k>=j;k--){
                result.add(matrix[m][k]);
            }

            for( int k=m-1;k>i;k--){
                result.add(matrix[k][j]);
            }
        }


        iterate(matrix,i+1,j+1,m-1,n-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
