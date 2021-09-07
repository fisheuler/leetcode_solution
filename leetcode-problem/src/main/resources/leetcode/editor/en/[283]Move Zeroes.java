//Given an integer array nums, move all 0's to the end of it while maintaining t
//he relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// Example 2: 
// Input: nums = [0]
//Output: [0]
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
//Follow up: Could you minimize the total number of operations done? Related Top
//ics Array Two Pointers 
// 👍 6096 👎 177


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int nonzeroIndex=0,nextIndex=0;
        while(nextIndex<=nums.length-1){
            if(nums[nextIndex]!=0){
                nums[nonzeroIndex]=nums[nextIndex];
                nonzeroIndex++;
            }
            nextIndex++;
        }

        while(nonzeroIndex<nums.length-1){
            nums[nonzeroIndex]=0;
            nonzeroIndex++;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
