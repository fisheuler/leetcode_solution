//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sorting 
// 👍 8511 👎 407


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length==1){
            return intervals;
        }

        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

        List<int[]> mergeList = new ArrayList();

        for(int[] item: intervals){
            if(mergeList.size==0 || mergeList.getLast()[1]<item[0]){
                mergeList.add(item);
            }else{
                mergeList.getLast()[1] = Math.Max(item[0],mergeList.getLast()[1]);
            }
        }

        return mergeList.toArrays(mergeList.size());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
