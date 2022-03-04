package solution;//Given a binary array nums, return the maximum length of a contiguous subarray
//with an equal number of 0 and 1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number of
// 0 and 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal nu
//mber of 0 and 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// nums[i] is either 0 or 1. 
// 
// Related Topics Array Hash Table Prefix Sum 
// 👍 3766 👎 164


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_525 {
    public int findMaxLength(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] prefixNums = new int[nums.length];

        prefixNums[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixNums[i] = prefixNums[i-1]+nums[i];
        }

        int maxLength = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int jPrefix = 0;
                if((j-1)>=0){
                    jPrefix = prefixNums[j-1];
                }

                int sum = prefixNums[i]-jPrefix;
                int sumLength = i-j+1;
                if(sum*2 == sumLength){
                   if(sumLength>maxLength){
                       maxLength = sumLength;
                   }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        Solution_525 solution = new Solution_525();

        int[] nums = new int[]{0,0,1,0,0,0,1,1}; // 6

//        int[] nums = new int[]{0,1};  // 2

//        int[] nums = new int[]{1,1,1,1,1,1,1,1}; // 0

        System.out.println(solution.findMaxLength(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
