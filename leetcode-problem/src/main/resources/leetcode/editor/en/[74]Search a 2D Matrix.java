//Write an efficient algorithm that searches for a value target in an m x n inte
//ger matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics Array Binary Search Matrix 
// 👍 6513 👎 252


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = matrix.length * matrix[0].length;

        while(low<=high){
            int mid = low + (high-low)/2;

            int r = mid/column;
            int c = mid % column;

            if(matrix[r][c] == target){
                return true;
            }

            if(matrix[r][c]>target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
