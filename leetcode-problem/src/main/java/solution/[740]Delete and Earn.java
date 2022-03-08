package solution;//You are given an integer array nums. You want to maximize the number of points
// you get by performing the following operation any number of times: 
//
// 
// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must d
//elete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
// 
// 
//
// Return the maximum number of points you can earn by applying the above operat
//ion some number of times. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,4,2]
//Output: 6
//Explanation: You can perform the following operations:
//- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
//- Delete 2 to earn 2 points. nums = [].
//You earn a total of 6 points.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,3,3,3,4]
//Output: 9
//Explanation: You can perform the following operations:
//- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
//
//- Delete a 3 again to earn 3 points. nums = [3].
//- Delete a 3 once more to earn 3 points. nums = [].
//You earn a total of 9 points. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics Array Hash Table Dynamic Programming 
// 👍 3482 👎 226


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_740 {
    /*

    A[n] we get Max(A[n])

    how to get Max(A[n+1])

     */

    TreeMap<Integer,Integer> map = new TreeMap<>();

    HashMap<String,Integer> memo = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        for(int num: nums){
            Integer count = map.get(num);
            if(count == null){
                count = 0;
            }
            count ++;

            map.put(num,count);
        }
        return max(map);

    }


    public String getIdentityKey(TreeMap<Integer,Integer> treeMap){
        StringBuilder sb = new StringBuilder();
        for(Integer integer: treeMap.keySet()){
            sb.append(integer+",");
        }
        return sb.toString();
    }

    public int max(TreeMap<Integer,Integer> hashMap){

        String identity = getIdentityKey(hashMap);

        if(memo.containsKey(identity)){
            return memo.get(identity);
        }

        if(hashMap.size()==0){
            return 0;
        }
        if(hashMap.size()==1){
            int key = hashMap.keySet().iterator().next();
            return key * (hashMap.get(key));
        }

        int max = 0;
        Set<Integer> keySet = new HashSet<>(hashMap.keySet());

        for(Integer key: keySet){
            int thisKeyValue = getThisValue(hashMap,key);
            if(thisKeyValue>max){
                max = thisKeyValue;
            }
        }
        memo.put(identity,max);

        return max;
    }

    public int getThisValue(TreeMap<Integer,Integer> hashMap,int value){


        Integer valueCount = hashMap.remove(value);
        int totalValue = value * valueCount;

        Integer count = hashMap.remove(value-1);
        Integer count2 = hashMap.remove(value+1);


        totalValue = totalValue + max(hashMap);

        if(valueCount!=null){
            hashMap.put(value,valueCount);
        }

        if(count!=null){
            hashMap.put(value-1,count);
        }

        if(count2!=null){
            hashMap.put(value+1,count2);
        }

        return totalValue;
    }


    public static void main(String[] args){
        Solution_740 solution = new Solution_740();

        int[] nums = new int[]{3,4,2};


        System.out.println(solution.deleteAndEarn(nums));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
