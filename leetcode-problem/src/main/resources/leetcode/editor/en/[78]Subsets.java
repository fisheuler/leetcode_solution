//Given an integer array nums of unique elements, return all possible subsets (t
//he power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 8850 👎 140


import java.lang.reflect.Array;
import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        for(int num: nums){
            List<List<Integer>> newSubsets = new ArrayList();
            for(List<Integer> temp:result){
                List<Integer> copy = new ArrayList<Integer>(temp);
                copy.add(num);

                newSubsets.add(copy);
            }
            result.addAll(newSubsets);
        }
        return result;
    }


    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        for( int i = (int) Math.pow(2,n);i<(int)Math.pow(2,n+1);++i){
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<n;++j){
                if(bitmask.charAt(j) == '1'){
                    temp.add(nums[j]);
                }
                result.add(temp);
            }
        }
        return result;
    }





    /*

    Pick a starting point.
    while(Problem is not solved)
        For each path from the starting point.
            check if selected path is safe, if yes select it
            and make recursive call to rest of the problem
            before which undo the current move.
        End For
    If none of the move works out, return false, NO SOLUTON.


     */




















}
//leetcode submit region end(Prohibit modification and deletion)
