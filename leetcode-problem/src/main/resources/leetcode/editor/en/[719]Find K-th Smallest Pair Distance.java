//The distance of a pair of integers a and b is defined as the absolute differen
//ce between a and b. 
//
// Given an integer array nums and an integer k, return the kth smallest distanc
//e among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,1], k = 1
//Output: 0
//Explanation: Here are all the pairs:
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//Then the 1st smallest distance pair is (1,1), and its distance is 0.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1], k = 2
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1,6,1], k = 3
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 104 
// 0 <= nums[i] <= 106 
// 1 <= k <= n * (n - 1) / 2 
// 
// Related Topics Array Two Pointers Binary Search Sorting 
// 👍 1604 👎 55


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
    这篇解析文章写的非常好，有编程珠玑的感觉和水准

    The basic idea for the trial and error algorithm is actually very simple and summarized below:

    Step 1: Construct a candidate solution.
    Step 2: Verify if it meets our requirements.
    Step 3: If it does, accept the solution; else discard it and repeat from Step 1.


I -- Construct a candidate solution
II -- Search space formed by all the candidate solutions
III -- Verify a given candidate solution
IV -- Count the number of pair distances no greater than the given integer
V -- How to traverse (or search) the search space efficiently
VI -- Putting everything together, aka, solutions


     */
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;
        int l =0;
        int r = nums[n-1] -nums[0];

        for(int cnt = 0; l<r;cnt=0){
            int m = l + (r-l)/2;

            for(int i=0,j=0;i<n;i++){
                while(j<n && nums[j]<=nums[i]+m) j++;
                cnt = cnt +(j-i)-1;
            }
            if(cnt < k){
                l = m+1;
            }else{
                r = m;
            }
        }

        return l;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
