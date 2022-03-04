package solution;//Given an integer array nums of unique elements, return all possible subsets (t
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


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_78 {
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

    public List<List<Integer>> subsets_2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        for( int i = (int) Math.pow(2,n);i<(int)Math.pow(2,n+1);++i){
            // https://www.topcoder.com/thrive/articles/A%20bit%20of%20fun:%20fun%20with%20bits

            //首位数字都是1
            String binaryString = Integer.toBinaryString(i);
            // substring把1之后的数字计算出来即可
            String bitmask = binaryString.substring(1);
            System.out.println(i+"\t"+ binaryString + "\t"+bitmask);
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



    public static void main(String[] args){
        Solution_78 solution = new Solution_78();

        int[] nums = new int[]{1,1,1,2,2,3}; // 6

        System.out.println(solution.subsets_2(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
