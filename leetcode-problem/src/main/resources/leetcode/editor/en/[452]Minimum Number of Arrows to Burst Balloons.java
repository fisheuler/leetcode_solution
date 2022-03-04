//There are some spherical balloons taped onto a flat wall that represents the X
//Y-plane. The balloons are represented as a 2D integer array points where points[
//i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches betwee
//n xstart and xend. You do not know the exact y-coordinates of the balloons. 
//
// Arrows can be shot up directly vertically (in the positive y-direction) from 
//different points along the x-axis. A balloon with xstart and xend is burst by an
// arrow shot at x if xstart <= x <= xend. There is no limit to the number of arro
//ws that can be shot. A shot arrow keeps traveling up infinitely, bursting any ba
//lloons in its path. 
//
// Given the array points, return the minimum number of arrows that must be shot
// to burst all balloons. 
//
// 
// Example 1: 
//
// 
//Input: points = [[10,16],[2,8],[1,6],[7,12]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
//- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
// 
//
// Example 2: 
//
// 
//Input: points = [[1,2],[3,4],[5,6],[7,8]]
//Output: 4
//Explanation: One arrow needs to be shot for each balloon for a total of 4 arro
//ws.
// 
//
// Example 3: 
//
// 
//Input: points = [[1,2],[2,3],[3,4],[4,5]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
//- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 105 
// points[i].length == 2 
// -231 <= xstart < xend <= 231 - 1 
// 
// Related Topics Array Greedy Sorting 
// 👍 2835 👎 88


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*

    https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/discuss/93703/Share-my-explained-Greedy-solution

    1 sort the array based the right position
    2 iterate array until the first left position large then the current position


    Some interesting examples:

    Very nice approach!!!

    BTW here are the questions that can be solved with the same technique

    56 Merge Intervals <- very similar😈
    435 Non-overlapping Intervals <- very similar😈
    252 Meeting Rooms
    253 Meeting Rooms II

    Practice them in a row for better understanding 😉

     */
    public int findMinArrowShots(int[][] points) {
        if( points.length == 0){
            return 0;
        }

        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));

        int arrowPos = points[0][1];
        int arrowCnt = 1;

        for( int i=1;i<points.length;i++){
            if(arrowPos>=points[i][0]){
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
