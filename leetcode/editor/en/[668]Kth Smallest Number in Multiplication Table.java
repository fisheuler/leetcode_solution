//Nearly everyone has used the Multiplication Table. The multiplication table of
// size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed). 
//
// Given three integers m, n, and k, return the kth smallest element in the m x 
//n multiplication table. 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 3, k = 5
//Output: 3
//Explanation: The 5th smallest number is 3.
// 
//
// Example 2: 
//
// 
//Input: m = 2, n = 3, k = 6
//Output: 6
//Explanation: The 6th smallest number is 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 3 * 104 
// 1 <= k <= m * n 
// 
// Related Topics Binary Search 
// 👍 818 👎 26


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo=1,hi = m*n;

        while(lo<hi){
            int mid = lo +(hi-lo)/2;
            if(enough(mid,m,n,k)){
                hi=mid;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }

    public boolean enough(int x, int m,int n,int k){
        int count=0;
        for(int i=1;i<=m;i++){
            count = count + Math.min(x/i,n);
        }
        return count>=k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
