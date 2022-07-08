package solution;//You are given a rectangular cake of size h x w and two arrays of integers
//horizontalCuts and verticalCuts where: 
//
// 
// horizontalCuts[i] is the distance from the top of the rectangular cake to 
//the iᵗʰ horizontal cut and similarly, and 
// verticalCuts[j] is the distance from the left of the rectangular cake to the 
//jᵗʰ vertical cut. 
// 
//
// Return the maximum area of a piece of cake after you cut at each horizontal 
//and vertical position provided in the arrays horizontalCuts and verticalCuts. 
//Since the answer can be a large number, return this modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
//Output: 4 
//Explanation: The figure above represents the given rectangular cake. Red 
//lines are the horizontal and vertical cuts. After you cut the cake, the green piece 
//of cake has the maximum area.
// 
//
// Example 2: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
//Output: 6
//Explanation: The figure above represents the given rectangular cake. Red 
//lines are the horizontal and vertical cuts. After you cut the cake, the green and 
//yellow pieces of cake have the maximum area.
// 
//
// Example 3: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 2 <= h, w <= 10⁹ 
// 1 <= horizontalCuts.length <= min(h - 1, 10⁵) 
// 1 <= verticalCuts.length <= min(w - 1, 10⁵) 
// 1 <= horizontalCuts[i] < h 
// 1 <= verticalCuts[i] < w 
// All the elements in horizontalCuts are distinct. 
// All the elements in verticalCuts are distinct. 
// 
// Related Topics Array Greedy Sorting 👍 2234 👎 317


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxH = getMax(horizontalCuts);
        maxH = Math.max(maxH,h-horizontalCuts[horizontalCuts.length-1]);
        long maxV = getMax(verticalCuts);
        maxV = Math.max(maxV,w-verticalCuts[verticalCuts.length-1]);
        int module = 1000000007;

        return (int) (maxH*maxV%module);

    }

    public static int getMax(int[] cuts){
        int max = cuts[0];

        for(int i=1;i<cuts.length;i++){
            max = Math.max(max,cuts[i]-cuts[i-1]);
        }
        return max;
    }


    public static void main(String[] args){
        Solution_1465 solution = new Solution_1465();

        int[] h = new int[]{2};
        int[] w = new int[]{2};
        System.out.println(solution.maxArea(1000000000, 1000000000,h,w));
    }




















}
//leetcode submit region end(Prohibit modification and deletion)
