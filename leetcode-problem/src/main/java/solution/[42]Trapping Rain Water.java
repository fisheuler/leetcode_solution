package solution;//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack 
// 👍 13364 👎 189


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_42 {
    /*

      某个下标i下的雨水数量:
      1 min(max(left(n-1),max(right(n+1))) - a[i]
      2 0

      1和2中的最大值

     */
    public int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int water = 0;
        int maxLeft = height[0];
        int maxRight = height[height.length-1];
        int left=1,right = height.length-2;

        while(left<=right){
            if(maxLeft<= maxRight){
                //说明i下标的最左侧的最大值小于右边right指向的值，那么左边的left已经可以知晓能控制的最大值了
                water = water + water(maxLeft,height[left]);
                maxLeft = Math.max(maxLeft,height[left]);
                left++;
            }else{
                water = water + water(maxRight,height[right]);
                maxRight = Math.max(maxRight,height[right]);
                right--;
            }
        }
        return water;
    }

    public int water(int maxValue,int value){
        return  Math.max(maxValue-value,0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
