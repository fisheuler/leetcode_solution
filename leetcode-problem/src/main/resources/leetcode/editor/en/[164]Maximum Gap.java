//Given an integer array nums, return the maximum difference between two success
//ive elements in its sorted form. If the array contains less than two elements, r
//eturn 0. 
//
// You must write an algorithm that runs in linear time and uses linear extra sp
//ace. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,6,9,1]
//Output: 3
//Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) 
//has the maximum difference 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [10]
//Output: 0
//Explanation: The array contains less than 2 elements, therefore return 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 
// Related Topics Array Sorting Bucket Sort Radix Sort 
// 👍 1712 👎 256


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    https://leetcode.com/problems/maximum-gap/discuss/50643/bucket-sort-JAVA-solution-with-explanation-O(N)-time-and-space

     */
    public int maximumGap(int[] nums) {
        if(nums.length<=1){
            return 0;
        }

        int min = nums[0];
        int max = nums[1];

        for(int i: nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }

        int gap = (int)Math.ceil((double)(max-min)/(nums.length-1));

        int[] minBucket = new int[nums.length];
        int[] maxBucket = new int[nums.length];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for(int value:nums){
            if(value == min || value==max){
                continue;
            }
            int index = (value-min)/gap;
            minBucket[index] = Math.min(minBucket[index],value);
            maxBucket[index] = Math.max(maxBucket[index],value);
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = min;

        /*
         * 由于必有一个bucket为空，所以可以知道，最大gap值大于bucketgap的值
         * 所以其值大小应该是由下一个bucket的最小值减去上一个bucket的最大值计算出来的
         */
        for(int i=0;i<nums.length-1;i++){
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            maxGap = Math.max(maxGap,(minBucket[i]-previous));
            previous = maxBucket[i];

        }

        maxGap  = Math.max(maxGap,max-previous);

        return maxGap;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
