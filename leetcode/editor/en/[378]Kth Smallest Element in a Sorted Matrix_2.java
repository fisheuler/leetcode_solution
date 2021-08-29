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
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /*
          根据二分查找来计算，二分查找不按照矩阵的坐标来计算，可以按照值的范围来计算
          逻辑参考：

          https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code


          主要问题是，lo这个值是通过二分查找的缩减得到的，而不是遍历matrix中元素得到的，如何保证lo的值一定在matrix中存在呢？

          注意代码中没有直接根据count值判断是否为K来直接判断结束，而是根据K值发生从小于K到大于等于K的变化的时候的值。

          而是当count数目小于k时候，将lo的值增加1。

          第K小的数满足的查找规律为：

          1 [matrix[0][0],mid] < k ，我们后续操作相当于是把mid的值加1

          2 [matrix[0][0],mid+1] >= k ; 那么mid+1就是我们要找的值




         其他解答：
the approach is to find the left bound in an array which matches answer.
eg. 1 2 3 4 5 5 5 5 6.
how to find the first target element 5?
when >5, right-1
when <5,left+1;
when =5 , right-1, in order to converge to the left bound.

this problem is the same.
when we find the match count, we need converge the count to the left bound
[1,2,3,5]
[2,3,5,7]
[3,5,8,9]
[5,8,9,14]
k=11




         */



        int lo = matrix[0][0], hi = matrix[matrix.length-1][matrix[0].length-1];


        while ( lo < hi){
            int mid = lo + (hi-lo)/2;

            int count = getCountLitterThan(matrix,mid);
            if ( count <k){
                lo = mid +1;
            }else{
                hi = mid;
            }

        }
        return lo;
    }


    public int getCountLitterThan(int[][] matrix,int num){
        int count = 0;
        int j=matrix[0].length-1;
        for(int i=0;i<matrix.length-1;i++){
            while((j>=0)&& matrix[i][j]>=num){
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
