//Given an array of integers heights representing the histogram's bar height whe
//re the width of each bar is 1, return the area of the largest rectangle in the h
//istogram. 
//
// 
// Example 1: 
//
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
//
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 105 
// 0 <= heights[i] <= 104 
// 
// Related Topics Array Stack Monotonic Stack 
// 👍 8365 👎 127


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)



     */
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            reutnr 0;
        }

        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];

        lessFromRight[heights.length-1] = heights.length;
        lessFromLeft[0] = -1;


        for( int i = 1;i<heights.length;i++){
            // one dimension skip table
            int p = i -1;
            while(p>=0 && heights[p] >= heights[i]){
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }


        for( int i = heights.length-2;i>=0;i++){
            int p = i+1;
            while(p<=(heights.length-1) && heights[p]>=heights[i]){
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        int maxArea = 0;
        for( int i = 0;i<heights.length;i++){
            // be caution here.
            maxArea = Math.max(maxArea,(lessFromRight[i]-lessFromLeft[i]-1)*heights[i]);
        }

        return maxArea;
    }






















}
//leetcode submit region end(Prohibit modification and deletion)
