package solution;//You are given an m x n binary matrix mat of 1's (representing soldiers) and 0'
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
class Solution_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int len = mat.length,width = mat[0].length;

        PriorityQueue<int[]> smallTopK = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return -(o1[0] - o2[0]);
                }else{
                    return -(o1[1] - o2[1]);
                }
            }
        });

        int j;
        for(int i=0;i<len;i++){
            j = 0;
            while(j<width &&mat[i][j]==1 ){
                j++;
            }

            smallTopK.offer(new int[]{i,j});
            if(smallTopK.size()>k){
                smallTopK.poll();
            }

        }

        int[] ans = new int[k];

        int number = k-1;

        while(number>=0){
            ans[number]= smallTopK.poll()[0];
            number--;
        }

        return ans;

    }



    public static void main(String[] args){
        Solution_1337 solution = new Solution_1337();

        int[][] mat = {{1,1,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1}};
        for( int num: solution.kWeakestRows(mat,3)){
            System.out.println(num);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
