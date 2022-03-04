//Given an array nums of size n, return the majority element. 
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. You
// may assume that the majority element always exists in the array. 
//
// 
// Example 1: 
// Input: nums = [3,2,3]
//Output: 3
// Example 2: 
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5 * 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//Follow-up: Could you solve the problem in linear time and in O(1) space? Relat
//ed Topics Array Hash Table Divide and Conquer Sorting Counting 
// 👍 5968 👎 278


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        int element = nums[0],num = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == element){
                num++;
            }else{
                if(num == 0){
                    element = nums[i];
                }else{
                    num--;
                }
            }
        }
        return element;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
