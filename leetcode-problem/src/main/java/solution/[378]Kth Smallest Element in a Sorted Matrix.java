package solution;//Given an n x n matrix where each of the rows and columns are sorted in ascendi
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


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        /*
         1 找出无序数组前K大的数，用小顶堆，堆顶元素是K个数的最小值，每次和堆顶的最小值比较；
         2 找出无序数组前K小的数，用大顶堆，堆顶元素是K个数的最大值，每次都和堆顶的最大值比较

         矩阵的算法的话，可以用分解法处理，将每一列都看成一个有序链表，然后做处理

         用一个小顶堆来确认排序次数，先将每一列的最小值放到最小堆中

         然后循环K次，每次都从最小堆中弹出最小值，同时将该值对应的列中（类似链表或者数组）的
         下一个值放入最小堆中即可。

         */

        int n = matrix.length;

        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<Tuple>();

        for(int i=0;i<n;i++){
            priorityQueue.add(new Tuple(matrix[0][i],0,i));
        }

        for(int i=0;i<k-1;i++){
            Tuple tuple = priorityQueue.poll();
            if((tuple.row+1)<n){
                priorityQueue.add(new Tuple(matrix[tuple.row+1][tuple.column],tuple.row+1,tuple.column));
            }
        }

        return priorityQueue.poll().val;

    }

    public class Tuple implements Comparable<Tuple>{
        int val;
        int row;
        int column;
        public Tuple(int val,int row,int column){
            this.val = val;
            this.row = row;
            this.column = column;
        }
        @Override
        public int compareTo(Tuple that){
            return this.val - that.val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
