//Given an integer array nums, move all the even integers at the beginning of th
//e array followed by all the odd integers. 
//
// Return any array that satisfies this condition. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,2,4]
//Output: [2,4,3,1]
//Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be acc
//epted.
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 2682 👎 111


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length<2){
            return nums;
        }
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                int temp = nums[k];
                nums[k++]=nums[i];
                nums[i]=temp;
            }
        }
        return nums;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
