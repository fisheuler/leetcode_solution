//Given an array nums which consists of non-negative integers and an integer m, 
//you can split the array into m non-empty continuous subarrays. 
//
// Write an algorithm to minimize the largest sum among these m subarrays. 
//
// 
// Example 1: 
//
// 
//Input: nums = [7,2,5,10,8], m = 2
//Output: 18
//Explanation:
//There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8],
//where the largest sum among the two subarrays is only 18.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], m = 2
//Output: 9
// 
//
// Example 3: 
//
// 
//Input: nums = [1,4,4], m = 3
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics Array Binary Search Dynamic Programming Greedy 
// 👍 4624 👎 130


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0,sum=0;
        for(int num: nums){
            max = Math.max(max,num);
            sum +=num;
        }

        if( m == 1){
            return sum;
        }

        long l = max ,h = sum;

        while(l<=h){
            int mid = l + (h-l)/2;
            if(valid(mid,nums,m)){
                r = mid-1;
            }else{
                h = mid +1;
            }
        }

        return l;

    }

    public boolean valid(long target,int[] nums, int m){
        int count =1;
        int total = 0;
        for(int num: nums){
            total +=num;
            if(total > target){
                total =num;
                count++;
                if(count>m){
                    return false;
                }
            }
        }
        return true;
    }




















}
//leetcode submit region end(Prohibit modification and deletion)
