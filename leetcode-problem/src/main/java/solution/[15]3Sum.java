package solution;//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 12111 👎 1180


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet();

        for(int i=0;i<nums.length-2;i++){
            int low = i+1,high = nums.length-1;
            int sum = 0 - nums[i];
            while(low<high){
                int  subSum = nums[low]+nums[high];
                if(subSum== sum){
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while((nums[low]==nums[low+1]) &&low<nums.length-2)low++;
                    low++;
                    while(nums[high-1]==nums[high] && high>low)high--;
                    high--;
                }else if ( subSum > sum){
                    high = high -1;
                }else {
                    low = low +1;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
