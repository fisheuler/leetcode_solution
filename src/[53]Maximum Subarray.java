//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 13424 👎 636


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_53 {
    /**
     *
     * F(n) 的最大值 ,两个候选项：
     *
     * optin1: F(n-1)最大值
     * option2: num[n]为尾的最大连续值
     *
     * Max(option1,option2)
     *
     * nums[n]为尾的最大连续值,maxEnd(n):
     *
     * option2: num[n];
     *
     * option3: maxEnd(n-1) + num[i];

     * max(option2,option3)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0],maxEnd = nums[0];

        for(int i=1;i<nums.length;i++){
            maxEnd = Math.max(maxEnd+nums[i],nums[i]);
            max = Math.max(max,maxEnd);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
