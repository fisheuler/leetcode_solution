//Given integer array nums, return the third maximum number in this array. If th
//e third maximum does not exist, return the maximum number. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,1]
//Output: 1
//Explanation: The third maximum is 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2]
//Output: 2
//Explanation: The third maximum does not exist, so the maximum (2) is returned 
//instead.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,2,3,1]
//Output: 1
//Explanation: Note that the third maximum here means the third maximum distinct
// number.
//Both numbers with value 2 are both considered as second maximum.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//Follow up: Can you find an O(n) solution? Related Topics Array Sorting 
// 👍 1183 👎 1929


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        if(nums.length<=2){
            return Math.max(nums[0],nums[1]);
        }

        int max1 = nums[0];

        int i=0;
        while(nums[i++]==max1);
        int max2 = Math.max(max1,nums[i]);
        max1 = Math.min(max1,nums[i]);

        while(num)

    }
}
//leetcode submit region end(Prohibit modification and deletion)
