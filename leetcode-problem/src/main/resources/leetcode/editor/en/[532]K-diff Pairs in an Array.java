//Given an array of integers nums and an integer k, return the number of unique 
//k-diff pairs in the array. 
//
// A k-diff pair is an integer pair (nums[i], nums[j]), where the following are 
//true: 
//
// 
// 0 <= i < j < nums.length 
// |nums[i] - nums[j]| == k 
// 
//
// Notice that |val| denotes the absolute value of val. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,4,1,5], k = 2
//Output: 2
//Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
//Although we have two 1s in the input, we should only return the number of uniq
//ue pairs.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], k = 1
//Output: 4
//Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) 
//and (4, 5).
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,1,5,4], k = 0
//Output: 1
//Explanation: There is one 0-diff pair in the array, (1, 1).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -107 <= nums[i] <= 107 
// 0 <= k <= 107 
// 
// Related Topics Array Hash Table Two Pointers Binary Search Sorting 
// 👍 2154 👎 1933


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> valueMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            valueMap.put(nums[i],i);
        }

        Set<String> result = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            /*
            |nums[i] - nums[j]| == k :

           =>  nums[i] - nums[j] == k or nums[i] - nums[j] == -k

           =>  nums[i] - k ==  nums[j] or  nums[i]+k = nums[j]

             */

            int value1 = nums[i] -k;
            int value2 = nums[i] + k;

            int[] values = new int[]{nums[i] -k,nums[i] + k};

            for(int value: values){
                if(valueMap.containsKey(value)){
                    int index = valueMap.get(value);
                    if(i != index){
                        result.add(trait(i,index));
                    }
                }
            }


        }

        return result.size();


    }

    public String trait(int a ,int b){
        if(a<b){
            return a+","+b;
        }else{
            return b+","+a;
        }
    }

    // Another beautiful algo
    class Solution {
        public int findPairs(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap();
            for (int num : nums)
                map.put(num, map.getOrDefault(num, 0) + 1);

            int result = 0;
            for (int i : map.keySet())
                if (k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1)
                    result++;
            return result;
        }
    }


    def findPairs(self, nums, k):
        res = 0
        c = collections.Counter(nums)
                for i in c:
                if k > 0 and i + k in c or k == 0 and c[i] > 1:
        res += 1
                return res


    def findPairs(self, nums, k):
        c = collections.Counter(nums)
            return  sum(k > 0 and i + k in c or k == 0 and c[i] > 1 for i in c)


}
//leetcode submit region end(Prohibit modification and deletion)
