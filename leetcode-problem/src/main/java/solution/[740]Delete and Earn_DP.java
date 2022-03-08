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
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_740_DP {
    /*

    A[n] we get Max(A[n])

    how to get Max(A[n+1])

     */

    Map<Integer,Integer> map = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        int[] slot = new int[10001];

        for(int num: nums){
            slot[num] +=num;
        }

        int take =0,skip=0;

        for(int s: slot){

            int skip_next = Math.max(take,skip);

            int take_next = skip + s;

            take = take_next;
            skip = skip_next;
        }

        return Math.max(take,skip);

    }


    public int max(Map<Integer,Integer> hashMap){

        if(hashMap.size()==0){
            return 0;
        }
        if(hashMap.size()==1){
            int key = hashMap.keySet().iterator().next();
            return key * (hashMap.get(key));
        }

        int max = 0;
        for(Integer value: hashMap.values()){
            int thisKeyValue = getThisValue(hashMap,value);
            if(thisKeyValue>max){
                max = thisKeyValue;
            }
        }
        return max;
    }

    public int getThisValue(Map<Integer,Integer> hashMap,int value){
        int totalValue = value;

        deleteValue(hashMap,value);

        Integer count = hashMap.remove(value-1);
        Integer count2 = hashMap.remove(value+1);


        totalValue = totalValue + max(hashMap);

        addValue(hashMap,value);
        if(count!=null){
            hashMap.put(value-1,count);
        }

        if(count2!=null){
            hashMap.put(value+1,count2);
        }

        return totalValue;
    }



    public void deleteValue(Map<Integer,Integer> hashMap,int value){

        int number = hashMap.get(value);
        number --;
        if(number==0){
            hashMap.remove(value);
        }
    }

    public void addValue(Map<Integer,Integer> hashMap,int value){
        Integer number = hashMap.get(value);

        if( number == null){
            hashMap.put(value,1);
        }else{
            number ++;
            hashMap.put(value,number);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
