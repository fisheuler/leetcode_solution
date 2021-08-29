//Given an n x n matrix where each of the rows and columns are sorted in ascendi
//ng order, return the kth smallest element in the matrix. 
//
// Note that it is the kth smallest element in the sorted order, not the kth dis
//tinct element. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//Output: 13
//Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the
// 8th smallest number is 13
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-5]], k = 1
//Output: -5
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// All the rows and columns of matrix are guaranteed to be sorted in non-decreas
//ing order. 
// 1 <= k <= n2 
// 
// Related Topics Array Binary Search Sorting Heap (Priority Queue) Matrix 
// 👍 4524 👎 207


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_378_2 {
    public int kthSmallest(int[][] matrix, int k) {
        /*
          根据二分查找来计算，二分查找不按照矩阵的坐标来计算，可以按照值的范围来计算
          逻辑参考：

          https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code

         */

        int lo = matrix[0][0], hi = matrix[matrix.length-1][matrix[0].length-1]+1;


        while ( lo < hi){
            int mid = lo + (hi-lo)/2;

            int count = getCountLitterThan(matrix,mid);
            if( count < k){
                lo = mid +1;
            }else{
                hi = mid ;
            }
        }
        return lo;
    }


    public int getCountLitterThan(int[][] matrix,int num){
        int count = 0;
        int j=matrix[0].length-1;
        for(int i=0;i<matrix.length-1;i++){
            while((j>=0)&&matrix[i][j]>num){
                j--;
            }
            if(j<0){
                break;
            }
            count = count + (j+1);
        }

        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
