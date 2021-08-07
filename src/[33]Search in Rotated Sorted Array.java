//There is an integer array nums sorted in ascending order (with distinct values
//). 
//
// Prior to being passed to your function, nums is rotated at an unknown pivot i
//ndex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+
//1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, 
//[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. 
//
// Given the array nums after the rotation and an integer target, return the ind
//ex of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// All values of nums are unique. 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 8975 👎 712


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_33 {
    public static int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    public static int search(int[] nums, int left,int right,int target){
        System.out.println("left:"+left + " right:"+right);
        if(right - left <5){
            for(int i = left;i<=right;i++){
                if(nums[i] == target){
                    return i;
                }
            }
            return -1;
        }
        int mid = left + (right-left)/2;

        int leftValue = nums[left],rightValue=nums[right],midValue = nums[mid];

        if( midValue == target){
            return mid;
        }
        if( leftValue == target){
            return left;
        }

        if( rightValue == target){
            return right;
        }

        if( leftValue < midValue){
            if(target>leftValue && target < midValue){
                return search(nums,left,mid-1,target);
            }else{
                return search(nums,mid+1,right,target);
            }
        }else{
            if( target>midValue && target<rightValue){
                return search(nums,mid+1,right,target);
            }else{
                return search(nums,left,mid-1,target);
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {283,287,288,294,295,299,0,1,2,6,12,14,17,20,24,26,33,35,38,42,46,48,50,53,56,57,58,64,66,67,69,72,75,76,78,80,81,82,83,84,90,92,93,95,99,104,108,109,112,117,122,123,124,126,130,144,145,147,152,160,164,166,168,172,173,174,176,180,181,182,183,187,188,192,195,196,197,199,200,203,207,208,212,214,217,219,222,234,239,240,241,242,245,246,248,252,254,255,256,258,262,264,266,267,269,272,273,274,280,281};

        System.out.println(search(nums,144));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
