package solution;//You are given an integer array height of length n. There are n vertical lines
//drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics Array Two Pointers Greedy 
// 👍 15315 👎 905


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_11 {
    public int maxArea(int[] height) {
        int i = 0 ,j = height.length-1;

        int leftMax = height[0],rightMax = height[height.length-1];

        int max = Math.min(leftMax,rightMax) * (j-i);
        while(i<j){
            if(leftMax<rightMax){
                while(height[i]<=leftMax && i<j){
                    i++;
                }
                leftMax = Math.max(leftMax,height[i]);
                max = Math.max(max,Math.min(leftMax,rightMax)*(j-i));
            }else{
                while(height[j]<=rightMax && j>i){
                    j--;
                }
                rightMax = Math.max(rightMax,height[j]);
                max = Math.max(max,Math.min(leftMax,rightMax)*(j-i));
            }
        }

        return max;
    }



    public static void main(String[] args){
        Solution_11 solution = new Solution_11();
//        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        int[] heights = new int[]{1,0,0,0,0,0,0,2,2};
        System.out.println(solution.maxArea(heights));

    }

}
//leetcode submit region end(Prohibit modification and deletion)
