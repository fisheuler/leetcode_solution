//You are given two integer arrays nums1 and nums2 sorted in ascending order and
// an integer k. 
//
// Define a pair (u, v) which consists of one element from the first array and o
//ne element from the second array. 
//
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums. 
//
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//Output: [[1,2],[1,4],[1,6]]
//Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,
//6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//Output: [[1,1],[1,1]]
//Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,
//2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// Example 3: 
//
// 
//Input: nums1 = [1,2], nums2 = [3], k = 3
//Output: [[1,3],[2,3]]
//Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 105 
// -109 <= nums1[i], nums2[i] <= 109 
// nums1 and nums2 both are sorted in ascending order. 
// 1 <= k <= 1000 
// 
// Related Topics Array Heap (Priority Queue) 
// 👍 2404 👎 149


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        if(nums1.length<=0 || nums2.length<=0){
            return res;
        }
        for(int i=0;i< nums1.length;i++){
            priorityQueue.add(new int[]{nums1[i],nums2[0],1});
        }
        while(k-->0 && !priorityQueue.isEmpty()){
            int[] item = priorityQueue.poll();

            List<Integer> result = new ArrayList<Integer>();
            result.add(item[0]);
            result.add(item[1]);
            res.add(result);
            if(item[2]==nums2.length){
                continue;
            }
            priorityQueue.add(new int[]{item[0],nums2[item[2]],item[2]+1});
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
