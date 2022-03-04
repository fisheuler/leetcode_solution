package solution;//Given an array of distinct integers candidates and a target integer target, re
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


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_39_2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsSearch(candidates,0,target,path,result);
        return result;
     }


    public void dfsSearch(int[] candidates, int current, int target,List<Integer> path,List<List<Integer>> result){
        if(target < 0){
            return;
        }
        if (target == 0){
            result.add(path);
            return;
        }

        for( int i=current;i<candidates.length;i++){
            List<Integer> currentPath = new ArrayList<>(path);
            currentPath.add(candidates[i]);
            dfsSearch(candidates,i,target-candidates[i],currentPath,result);
        }
    }




    public static void main(String[] args){
        Solution_39_2 solution = new Solution_39_2();

        // 2,3,6,7
        int[] nums = new int[]{2,3,6,7}; // 6

        List<List<Integer>>  result = solution.combinationSum(nums,7);
        System.out.println(result.size());
        System.out.println(result);

    }



}
//leetcode submit region end(Prohibit modification and deletion)
