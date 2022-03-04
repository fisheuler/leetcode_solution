//Given an array of distinct integers candidates and a target integer target, re
//turn a list of all unique combinations of candidates where the chosen numbers su
//m to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. T
//wo combinations are unique if the frequency of at least one of the chosen number
//s is different. 
//
// It is guaranteed that the number of unique combinations that sum up to target
// is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple ti
//mes.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// All elements of candidates are distinct. 
// 1 <= target <= 500 
// 
// Related Topics Array Backtracking 
// 👍 9200 👎 207


import java.lang.reflect.Array;
import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combinationSumbyOneMinus(candidates,target,from)
    }

    public List<List<Integer>> combinationSum(int[] candidates,int target ,int from){

        if ( target < = 0){
            return new ArrayList<>();
        }
        if(from == candidates.length-1){
            if(candidates[from] == target){
                return new ArrayList<>(candidates[from]);
            }

            return new ArrayList<>();;
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i*candidates[from]<=target;i++){
            List<List<Integer>> subResult = combinationSum(candidates,target-i*candidates[from],from);
            List<List<Integer>> subResult2 = combinationSum(candidates,target-i*candidates[from],from+1);
            if(subResult!=null){
                result.addAll(subResult);
            }
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
