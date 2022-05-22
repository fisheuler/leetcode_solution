package solution;//Given an integer array nums, you need to find one continuous subarray that if
//you only sort this subarray in ascending order, then the whole array will be sor
//ted in ascending order. 
//
// Return the shortest such subarray and output its length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
//whole array sorted in ascending order.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//Follow up: Can you solve it in O(n) time complexity? Related Topics Array Two 
//Pointers Stack Greedy Sorting Monotonic Stack 
// 👍 5031 👎 204


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_581 {
    /*

https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103057/java-on-time-o1-space


    if(nums == null) return 0;
    if(nums.Length == 0 || nums.Length == 1) return 0;

    int max = Int32.MinValue;
    int end = -2;
    //iterate from beginning of array
    //find the last element which is smaller than the last seen max from
    //its left side and mark it as end
    for(int i = 0; i < nums.Length; i ++){
        max = Math.Max(max, nums[i]);
        if(nums[i] < max)
            end = i;
    }

    int min = Int32.MaxValue;
    int begin = -1;
    //iterate from end of array
    //find the last element which is bigger than the last seen min from
    //its right side and mark it as begin
    for(int i = nums.Length - 1; i >= 0; i --){
        min = Math.Min(min, nums[i]);
        if(nums[i] > min)
            begin = i;
    }

    return end - begin + 1;


     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length,beg = -1, end = -2, min = nums[n-1],max = nums[0];

        for (int i = 1;i<n;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[n-1-i]);
            if(nums[i]<max){
                end = i;
            }
            if(nums[n-1-i]>min){
                beg = n -1 -i;
            }
        }

        return end -beg +1;
    }

    public static void main(String[] args){
        Solution_581 solution = new Solution_581();

        /*
        10
        1283
         */
        int[] nums = {2,6,4,8,10,9,15};

        System.out.println(solution.findUnsortedSubarray(nums));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
