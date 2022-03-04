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


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_525_HashMap {
    public int findMaxLength(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        HashMap<Integer,Integer> preSumIndex = new HashMap<Integer,Integer>();

        preSumIndex.put(0,-1);

        int sum = 0, maxLength = 0;

        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            // sum[j] = sum[k] => sum(k+1....j) = 0
            if(preSumIndex.containsKey(sum)){
                int k = preSumIndex.get(sum);
                int length = i-k;
                maxLength = Math.max(maxLength,length);

            }else{
                preSumIndex.put(sum,i);
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
