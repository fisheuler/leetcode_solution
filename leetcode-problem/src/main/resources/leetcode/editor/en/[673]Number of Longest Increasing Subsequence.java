//Given an integer array nums, return the number of longest increasing subsequen
//ces. 
//
// Notice that the sequence has to be strictly increasing. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 
//3, 5, 7].
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2]
//Output: 5
//Explanation: The length of longest continuous increasing subsequence is 1, and
// there are 5 subsequences' length is 1, so output 5.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2000 
// -106 <= nums[i] <= 106 
// 
// Related Topics Array Dynamic Programming Binary Indexed Tree Segment Tree 
// 👍 2604 👎 135


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC%2B%2B-Simple-dp-solution-with-explanation

    len[i]: the length of the Longest Increasing Subsequence which ends with nums[i].

    cnt[i]: the number of the Longest Increasing Subsequence which ends with nums[i].

    穷举

    状态转移方程：

    https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107318/C%2B%2B-DP-with-explanation-O(n2)

    len[k+1] = max(len[k+1], len[i]+1) for all i <= k and nums[i] < nums[k+1];

    cnt[k+1] = sum(cnt[i]) for all i <= k and nums[i] < nums[k+1] and len[i] = len[k+1]-1;


     */
    public int findNumberOfLIS(int[] nums) {
       int[] length= new int[nums.length];
       int[] count = new int[nums.length];
       int maxLength = 0,maxCount=0;
       for(int i=0;i<nums.length;i++){
           length[i]=count[i] = 1;
           for(int j=0;j<i;j++){
               if(nums[i]>nums[j]){
                   if(length[i]==length[j]+1){
                       count[i] = count[i] + count[j];
                   }else if (length[i] < length[j]+1){
                       length[i] = length[j]+1;
                       count[i] = count[j];
                   }
               }
           }

           if(maxLength == length[i]){
               maxCount = maxCount + count[i];
           }else if (maxLength<length[i]){
               maxLength = length[i];
               maxCount = count[i];
           }
       }

       return maxCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
