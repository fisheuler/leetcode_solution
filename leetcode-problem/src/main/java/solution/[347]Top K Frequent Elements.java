package solution;//Given an integer array nums and an integer k, return the k most frequent eleme
//nts. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), w
//here n is the array's size. 
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority Que
//ue) Bucket Sort Counting Quickselect 
// 👍 7877 👎 340


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int num :nums){
            int freq = freqMap.getOrDefault(num,0) +1;
            freqMap.put(num,freq);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });

        for(Integer key: freqMap.keySet()){
            priorityQueue.add(new int[]{freqMap.get(key),key});
        }

        int[] result = new int[k];
        int i = 0;
        while(i<k){
            result[i]=priorityQueue.poll()[1];
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        Solution_347 solution = new Solution_347();

        int[] nums = new int[]{1,1,1,2,2,3};
        int k =2;

        for(int num: solution.topKFrequent(nums,k)){
            System.out.println(num);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
