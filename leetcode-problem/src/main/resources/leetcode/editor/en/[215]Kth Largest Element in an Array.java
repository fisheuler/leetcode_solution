//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Quickse
//lect 
// 👍 6342 👎 383


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue();

        for(int num:nums){
            if(q.size()<k){
                q.add(num);
            }else{
                if(q.peek()<num){
                    q.poll();
                    q.add(num);
                }
            }
        }
        return q.peek();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
