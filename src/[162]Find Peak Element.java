//A peak element is an element that is strictly greater than its neighbors. 
//
// Given an integer array nums, find a peak element, and return its index. If th
//e array contains multiple peaks, return the index to any of the peaks. 
//
// You may imagine that nums[-1] = nums[n] = -∞. 
//
// You must write an algorithm that runs in O(log n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index num
//ber 2. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak ele
//ment is 2, or index number 5 where the peak element is 6. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// nums[i] != nums[i + 1] for all valid i. 
// 
// Related Topics Array Binary Search 
// 👍 3734 👎 2946


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_162 {
    public static int findPeakElement(int[] nums) {
        if(nums.length<=2){
            return -1;
        }

        int low =0,high = nums.length-1;

        while(low<high){
            int mid = low + (high-low)/2;

            if(nums[mid+1]>nums[mid]){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args){
        int[] nums = {1,2,1,3,5,6,4};
        int index= findPeakElement(nums);
        System.out.println("index="+index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
