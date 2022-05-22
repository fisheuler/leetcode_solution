package solution;//Given an array of n integers nums, a 132 pattern is a subsequence of three int
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


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_132 {
    /*
    https://leetcode.com/problems/132-pattern/discuss/94071/Single-pass-C%2B%2B-O(n)-space-and-time-solution-(8-lines)-with-detailed-explanation.

    1 从后往前入栈，维护一个Monotonic decrease stack
    2 碰到新元素，根据其与堆顶元素的关系进行下一步的操作：
        2.1 小于等于堆顶元素，直接入堆
        2.2 大于堆顶元素，那么一直弹堆顶元素，直到其小于现有的堆顶元素，在这个过程中：
            （1）需要更新secondMax的值；
             (2) 并且把当前元素入栈

     */

    public static boolean find132pattern(int[] nums){
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

    public static void main(String[] args){
        int[] nums= {1,10,11,9,4,5,6,7,8,9,10};

        find132pattern(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
