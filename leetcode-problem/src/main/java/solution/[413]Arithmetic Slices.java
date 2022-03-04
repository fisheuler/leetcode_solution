package solution;//An integer array is called arithmetic if it consists of at least three element
//s and if the difference between any two consecutive elements is the same. 
//
// 
// For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequence
//s. 
// 
//
// Given an integer array nums, return the number of arithmetic subarrays of num
//s. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 3
//Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,
//2,3,4] itself.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 
// 👍 3149 👎 235


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_413 {

    /*

    1, 2 ,3,4, 5


    1,2,3
    2,3,4
    3,4,5
    1,2,3,4
    2,3,4,5
    1,2,3,4,5

    n*(n+1)/2

     */
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }

        int step = nums[1]-nums[0];
        int sameStepNum = 0;
        int totalNum = 0;
        for(int i = 2;i<nums.length;i++){
            if((nums[i]-nums[i-1]) == step){
                sameStepNum= sameStepNum +1;
            }else{
                step = nums[i] - nums[i-1];
                totalNum = addNum(totalNum,sameStepNum);
                sameStepNum = 0;
            }
        }
        if(sameStepNum>0){
            totalNum = addNum(totalNum,sameStepNum);
        }
        return totalNum;
    }

    public int addNum(int totalNum,int sameStepNum){
        return totalNum = totalNum + sameStepNum*(sameStepNum+1)/2;
    }

    public static void main(String[] args){
        Solution_413 solution = new Solution_413();

        int[] nums = new int[]{1,2,3,4,5}; // 6

//        int[] nums = new int[]{0,1};  // 2

//        int[] nums = new int[]{1,1,1,1,1,1,1,1}; // 0

        System.out.println(solution.numberOfArithmeticSlices(nums));
    }



}

//leetcode submit region end(Prohibit modification and deletion)
