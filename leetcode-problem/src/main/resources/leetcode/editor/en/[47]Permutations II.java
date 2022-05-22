//Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking 
// 👍 4942 👎 93


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer,Integer> counter = new HashMap<>();
        for(int num: nums){
            if(counter.containsKey(num)){
                counter.put(num,counter.get(num)+1);
            }else{
                counter.put(num,1);
            }
        }

        LinkedList<Integer> comb = new LinkedList<>();

        this.backtrack(comb,nums.length,counter,results);
        return results;
    }


    public void backtrack(LinkedList<Integer> comb,
                          Integer N,
                          HashMap<Integer,Integer> counter,
                          List<List<Integer>> results){

        if(comb.size()==N){
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for(Map.Entry<Integer,Integer> entry: counter.entrySet()){
            Integer num = entry.getKey();
            Integer count = entry.getValue();

            if ( count == 0){
                continue;
            }
            comb.addLast(num);
            counter.put(num,count-1);
            backtrack(comb,N,counter,results);
            comb.removeLast();
            counter.put(num,count);
        }
    }




















}
//leetcode submit region end(Prohibit modification and deletion)
