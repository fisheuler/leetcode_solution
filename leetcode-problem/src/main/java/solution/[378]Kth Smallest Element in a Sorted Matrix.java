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
// ð 4524 ð 207


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        /*
         1 æ¾åºæ åºæ°ç»åKå¤§çæ°ï¼ç¨å°é¡¶å ï¼å é¡¶åç´ æ¯Kä¸ªæ°çæå°å¼ï¼æ¯æ¬¡åå é¡¶çæå°å¼æ¯è¾ï¼
         2 æ¾åºæ åºæ°ç»åKå°çæ°ï¼ç¨å¤§é¡¶å ï¼å é¡¶åç´ æ¯Kä¸ªæ°çæå¤§å¼ï¼æ¯æ¬¡é½åå é¡¶çæå¤§å¼æ¯è¾

         ç©éµçç®æ³çè¯ï¼å¯ä»¥ç¨åè§£æ³å¤çï¼å°æ¯ä¸åé½çæä¸ä¸ªæåºé¾è¡¨ï¼ç¶ååå¤ç

         ç¨ä¸ä¸ªå°é¡¶å æ¥ç¡®è®¤æåºæ¬¡æ°ï¼åå°æ¯ä¸åçæå°å¼æ¾å°æå°å ä¸­

         ç¶åå¾ªç¯Kæ¬¡ï¼æ¯æ¬¡é½ä»æå°å ä¸­å¼¹åºæå°å¼ï¼åæ¶å°è¯¥å¼å¯¹åºçåä¸­ï¼ç±»ä¼¼é¾è¡¨æèæ°ç»ï¼ç
         ä¸ä¸ä¸ªå¼æ¾å¥æå°å ä¸­å³å¯ã

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
