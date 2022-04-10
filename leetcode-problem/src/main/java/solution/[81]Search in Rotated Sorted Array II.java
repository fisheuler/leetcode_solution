package solution;//There is an integer array nums sorted in non-decreasing order (not necessarily
// with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot ind
//ex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true if
// target is in nums, or false if it is not in nums. 
//
// You must decrease the overall operation steps as much as possible. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
//
// 
// Follow up: This problem is similar to Search in Rotated Sorted Array, but num
//s may contain duplicates. Would this affect the runtime complexity? How and why?
// 
// Related Topics Array Binary Search 
// 👍 3574 👎 664


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_81 {
    public boolean search(int[] nums, int target) {
        return recursiveSearch(nums,target,0,nums.length-1);
    }

    public boolean recursiveSearch(int[] nums, int target,int low,int high){
        while(low<=high){

            if(high - low <=5){
                for(int j=low;j<=high;j++){
                    if(nums[j] == target){
                        return true;
                    }
                }
                return false;
            }
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[low] == nums[mid]  && nums[mid] == nums[high]){
                return recursiveSearch(nums,target,low,mid-1) ||
                        recursiveSearch(nums,target,mid+1,high);
            }else{

                if(nums[low]<nums[mid]){
                    if(target>=nums[low] && target<nums[mid]){
                        high = mid-1;
                    }else{
                        low = mid +1;
                    }

                }else{

                    if( target>nums[mid] && target<=nums[high]){
                        low = mid +1;
                    }else{
                        high = mid -1;
                    }
                }
            }

        }
        return false;

    }

    public static void main(String[] args){
        Solution_81 solution = new Solution_81();

        // [1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1]
        //2

        // 1,0,1,1,1
        // 0

        // 1,0,1,1,1,1
        // 0
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}; // 6

        System.out.println(solution.search(nums,2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
