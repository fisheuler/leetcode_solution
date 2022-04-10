package solution;//Given an array of integers nums containing n + 1 integers where each integer i
//s in the range [1, n] inclusive. 
//
// There is only one repeated number in nums, return this repeated number. 
//
// You must solve the problem without modifying the array nums and uses only con
//stant extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,4,2,2]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [3,1,3,4,2]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 105 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// All the integers in nums appear only once except for precisely one integer wh
//ich appears two or more times. 
// 
//
// 
// Follow up: 
//
// 
// How can we prove that at least one duplicate number must exist in nums? 
// Can you solve the problem in linear runtime complexity? 
// 
// Related Topics Array Two Pointers Binary Search Bit Manipulation 
// 👍 12277 👎 1373


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_287 {
    public int findDuplicate(int[] nums) {

        int length = nums.length;
        int total = (1 + length-1) * (length-1)/2;

        int arraySum = 0;

        for(int num: nums){
            arraySum +=num;
        }
        return arraySum - total;
    }

    public int findDuplicate_2(int[] nums) {
        int length = nums.length;
        int total = (1 + length-1) * (length-1)/2;

        int arraySum = 0;

        for(int num: nums){
            arraySum +=num;
        }
        return arraySum - total;
    }

    public static void main(String[] args){
        Solution_287 solution = new Solution_287();

        int[] nums = new int[]{1,3,4,2,2};

        System.out.println(solution.findDuplicate(nums));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
