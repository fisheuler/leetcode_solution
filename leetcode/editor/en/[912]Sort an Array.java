//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 104 
// -5 * 104 <= nums[i] <= 5 * 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Merge S
//ort Bucket Sort Radix Sort Counting Sort 
// 👍 1111 👎 417


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length<=1){
            return nums;
        }

        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums,int low, int high){
        if(low>=high){
            return;
        }
        int index = partition(nums,low,high);

        quickSort(nums,low,index-1);
        quickSort(nums,index+1,high);
    }

    public int partition(int[] nums,int low ,int high){
        int pivot = nums[low];
        int start = low;
        while(low<high){
            while(low<high && nums[high]>=pivot) high--;
            while(low<high && nums[low]<=pivot) low++;
            if(low>=high){
                break;
            }
            int temp = nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
        }
        nums[start] = nums[low];
        nums[low] = pivot;
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
