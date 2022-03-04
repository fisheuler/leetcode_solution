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
class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return combinationSum(candidates,target,0);
    }

    public List<List<Integer>> combinationSum(int[] candidates,int target ,int from){

        List<List<Integer>> result = new ArrayList<>();

        if(target<0){
            return null;
        }

        if(from>=candidates.length){
            return null;
        }

        if (target == 0){
            return result;
        }

//
//        if(candidates[from] == target){
//            List<Integer> subResult = new ArrayList<>();
//            subResult.add(candidates[from]);
//            result.add(subResult);
//            return result;
//        }
//


        //包含0个
        List<List<Integer>> subResult =  combinationSum(candidates,target,from+1);
        if(subResult!=null){
            result.addAll(subResult);
        }

        for(int i=1;i*candidates[from]<=target;i++){
            List<List<Integer>> sub = combinationSum(candidates,target-i*candidates[from],from+1);
            addToResult(sub,candidates[from],i,result);
        }

        return result;

    }

    public void addToResult(List<List<Integer>> subResult,int item,int number,List<List<Integer>> result){
        List<Integer> itemArray = new ArrayList();
        for(int i=0;i<number;i++){
            itemArray.add(item);
        }

        if(subResult==null){
            // 没有找到
        }else{
            //找到了，放进去
            if(subResult.size()==0){
                result.add(itemArray);
            }else{
                for(List<Integer> sub:subResult){
                    sub.addAll(itemArray);
                    result.add(sub);
                }

            }
        }

    }

    public static void main(String[] args){
        Solution_39 solution = new Solution_39();

        // 2,3,6,7
        int[] nums = new int[]{2,3,6}; // 6

        List<List<Integer>>  result = solution.combinationSum(nums,7);
        System.out.println(result.size());
        System.out.println(result);

    }


}
//leetcode submit region end(Prohibit modification and deletion)
