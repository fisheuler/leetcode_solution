//You are given an m x n binary matrix mat of 1's (representing soldiers) and 0'
//s (representing civilians). The soldiers are positioned in front of the civilian
//s. That is, all the 1's will appear to the left of all the 0's in each row. 
//
// A row i is weaker than a row j if one of the following is true: 
//
// 
// The number of soldiers in row i is less than the number of soldiers in row j.
// 
// Both rows have the same number of soldiers and i < j. 
// 
//
// Return the indices of the k weakest rows in the matrix ordered from weakest t
//o strongest. 
//
// 
// Example 1: 
//
// 
//Input: mat = 
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]], 
//k = 3
//Output: [2,0,3]
//Explanation: 
//The number of soldiers in each row is: 
//- Row 0: 2 
//- Row 1: 4 
//- Row 2: 1 
//- Row 3: 2 
//- Row 4: 5 
//The rows ordered from weakest to strongest are [2,0,3,1,4].
// 
//
// Example 2: 
//
// 
//Input: mat = 
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]], 
//k = 2
//Output: [0,2]
//Explanation: 
//The number of soldiers in each row is: 
//- Row 0: 1 
//- Row 1: 4 
//- Row 2: 1 
//- Row 3: 1 
//The rows ordered from weakest to strongest are [0,2,3,1].
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] is either 0 or 1. 
// 
// Related Topics Array Binary Search Sorting Heap (Priority Queue) Matrix 
// 👍 1556 👎 91


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int len = mat.length,width = mat[0].length;

        PriorityQueue<Node> smallTopK = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.length == o2.length){
                    return o1.index - o2.index;
                }else{
                    o1.length - o2.length;
                }
            }
        });
        int j=0;
        for(int i=0;i<len;i++){
            j = 0;
            while(mat[i][j]==1){
                j++;
            }
            if(smallTopK.size()<k){
                smallTopK.add(new Node(i,j));
            }else{
                smallTopK.add(new Node(i,j));
                smallTopK.poll();
            }
        }

        int[] ans = new int[k-1];

        int number = 0;

        while(number<k){
            ans[number] = smallTopK.poll().index;
            number++;
        }

        return ans;

    }
    class Node(){
        int index;
        int length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
