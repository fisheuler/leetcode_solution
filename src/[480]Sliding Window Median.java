//The median is the middle value in an ordered integer list. If the size of the 
//list is even, there is no middle value. So the median is the mean of the two mid
//dle values. 
//
// 
// For examples, if arr = [2,3,4], the median is 3. 
// For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5. 
// 
//
// You are given an integer array nums and an integer k. There is a sliding wind
//ow of size k which is moving from the very left of the array to the very right. 
//You can only see the k numbers in the window. Each time the sliding window moves
// right by one position. 
//
// Return the median array for each window in the original array. Answers within
// 10-5 of the actual value will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
//Explanation: 
//Window position                Median
//---------------                -----
//[1  3  -1] -3  5  3  6  7        1
// 1 [3  -1  -3] 5  3  6  7       -1
// 1  3 [-1  -3  5] 3  6  7       -1
// 1  3  -1 [-3  5  3] 6  7        3
// 1  3  -1  -3 [5  3  6] 7        5
// 1  3  -1  -3  5 [3  6  7]       6
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
//Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 105 
// 231 <= nums[i] <= 231 - 1 
// 
// Related Topics Array Hash Table Sliding Window Heap (Priority Queue) 
// 👍 1642 👎 106


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_480 {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
    public int[] medianSlidingWindow(int[] nums, int k) {

        if(nums.length<k){
            return null;
        }
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            priorityQueue.add(nums[i]);
        }

        int i=0,l=0,j=k;
        result[l++]=priorityQueue.poll();
        while(j<nums.length){
            if(j>nums.length){
                break;
            }
            priorityQueue.remove(nums[i++]);
            priorityQueue.add(nums[j]);
            result[l++]=priorityQueue.poll();
            j++;
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
