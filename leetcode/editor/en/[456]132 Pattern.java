//Given an array of n integers nums, a 132 pattern is a subsequence of three int
//egers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < n
//ums[j]. 
//
// Return true if there is a 132 pattern in nums, otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: false
//Explanation: There is no 132 pattern in the sequence.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,1,4,2]
//Output: true
//Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,3,2,0]
//Output: true
//Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3,
// 0] and [-1, 2, 0].
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array Binary Search Stack Monotonic Stack Ordered Set 
// 👍 2610 👎 150


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        int secondMax = Integer.MIN_VALUE;

        Stack<Integer> firstMax = new Stack();
        for(int i=nums.length-1;i>=0;i--){
            if( nums[i]<secondMax){
                return true;
            }else {
                while(!firstMax.isEmpty() && nums[i]>firstMax.peek()){
                    secondMax = firstMax.pop();
                }
                firstMax.push(nums[i]);
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
