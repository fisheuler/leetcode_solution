package solution;//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 6623 👎 220


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_34 {
    public int[] searchRange(int[] nums, int target) {

        int[] index = new int[]{-1,-1};

        if(nums.length<=0){
            return index;
        }

        int oneIndex = findOneIndex(nums,target);
        if(oneIndex == -1){
            return index;
        }

        int firstIndex = oneIndex,lastIndex = oneIndex;
        while((firstIndex-1)>=0 &&nums[firstIndex-1]==target){
            firstIndex--;
        }
        while((lastIndex+1)<=nums.length-1 && nums[lastIndex+1]==target){
            lastIndex++;
        }

        index[0]=firstIndex;
        index[1]=lastIndex;

        return index;

    }

    public int findOneIndex(int[] nums,int target){
        int low = 0,high= nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] <target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
