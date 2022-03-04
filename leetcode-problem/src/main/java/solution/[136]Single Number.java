package solution;//Given a non-empty array of integers nums, every element appears twice except f
//or one. Find that single one. 
//
// You must implement a solution with a linear runtime complexity and use only c
//onstant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,1]
//Output: 1
// Example 2: 
// Input: nums = [4,1,2,1,2]
//Output: 4
// Example 3: 
// Input: nums = [1]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -3 * 104 <= nums[i] <= 3 * 104 
// Each element in the array appears twice except for one element which appears 
//only once. 
// 
// Related Topics Array Bit Manipulation 
// 👍 9111 👎 315


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_136 {
    public int singleNumber(int[] nums) {

        int result =nums[0];

        for(int i=1;i<nums.length;i++){
            result = result^nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        Solution_136 solution = new Solution_136();

        int[] nums = new int[]{1,1,2,2,3}; // 6

        System.out.println(solution.singleNumber(nums));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
