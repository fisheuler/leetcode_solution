package solution;//You are given an integer array nums and an integer k. 
//
// In one operation, you can pick two numbers from the array whose sum equals k 
//and remove them from the array. 
//
// Return the maximum number of operations you can perform on the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4], k = 5
//Output: 2
//Explanation: Starting with nums = [1,2,3,4]:
//- Remove numbers 1 and 4, then nums = [2,3]
//- Remove numbers 2 and 3, then nums = []
//There are no more pairs that sum up to 5, hence a total of 2 operations. 
//
// Example 2: 
//
// 
//Input: nums = [3,1,3,4,3], k = 6
//Output: 1
//Explanation: Starting with nums = [3,1,3,4,3]:
//- Remove the first two 3's, then nums = [1,4,3]
//There are no more pairs that sum up to 6, hence a total of 1 operation. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 109 
// 1 <= k <= 109 
// 
// Related Topics Array Hash Table Two Pointers Sorting 
// 👍 797 👎 26


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1679 {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        int i=0;
        for(int num: nums){
            Integer another = map.get(k-num);
            if(another==null){
                Integer numCount = map.get(num);
                if(numCount==null){
                    map.put(num,1);
                }else{
                    numCount++;
                    map.put(num,numCount);
                }
            }else{
                System.out.println(" i:"+i +" num:"+num +" anotherNum:"+(k-num) + " count:"+another );
                count++;
                another--;
                map.put(k-num,another);
                if(another==0){
                    map.remove(k-num);
                }
            }
            i++;
        }
        return count;
    }


    public static void main(String[] args){
        Solution_1679 solution = new Solution_1679();
        int[] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;

        System.out.println(solution.maxOperations(nums,k));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
