package solution;//You are given a sorted unique integer array nums.
//
// Return the smallest sorted list of ranges that cover all the numbers in the a
//rray exactly. That is, each element of nums is covered by exactly one of the ran
//ges, and there is no integer x such that x is in one of the ranges but not in nu
//ms. 
//
// Each range [a,b] in the list should be output as: 
//
// 
// "a->b" if a != b 
// "a" if a == b 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// Example 2: 
//
// 
//Input: nums = [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: The ranges are:
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 20 
// -231 <= nums[i] <= 231 - 1 
// All the values of nums are unique. 
// nums is sorted in ascending order. 
// 
// Related Topics Array 
// 👍 1461 👎 898


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if(nums==null || nums.length==0){
            return result;
        }

        if(nums.length == 1){
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int start = nums[0],end= nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] == (end +1)){
                end = nums[i];
            }else{
                result.add(getMark(start,end));
                start = nums[i];end = nums[i];
            }
        }

        result.add(getMark(start,end));


        return result;
    }


    public String getMark(int start ,int end){
        if(end != start){
            return String.valueOf(start)+"->"+String.valueOf(end);
        }else{
            return String.valueOf(start);
        }
    }

    public static void main(String[] args){
        Solution_228 solution = new Solution_228();

        int[] nums= new int[]{0,1,2,4,5,7};

        System.out.println(solution.summaryRanges(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
