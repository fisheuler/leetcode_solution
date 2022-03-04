package solution;//Given an integer n, return an array ans of length n + 1 such that for each i (
//0 <= i <= n), ans[i] is the number of 1's in the binary representation of i. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// Example 2: 
//
// 
//Input: n = 5
//Output: [0,1,1,2,1,2]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 105 
// 
//
// 
// Follow up: 
//
// 
// It is very easy to come up with a solution with a runtime of O(n log n). Can 
//you do it in linear time O(n) and possibly in a single pass? 
// Can you do it without using any built-in function (i.e., like __builtin_popco
//unt in C++)? 
// 
// Related Topics Dynamic Programming Bit Manipulation 
// 👍 5925 👎 290


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_338 {
    public int[] countBits(int n) {

        if(n==0){
            return new int[]{0};
        }

        if(n == 1){
            return new int[]{0,1};
        }
        int[] bitArray = new int[n+1];

        bitArray[0]=0;
        bitArray[1]=1;
        for(int i=2;Math.pow(2,i-1)<=n;i++){
            int iterateStartIndex = (int)Math.pow(2,i-1);
//            System.out.println("i="+i +"\t" + "startIndex=" + iterateStartIndex + " endIndex=" + iterateStartIndex*2);
            for(int k = iterateStartIndex;k<Math.pow(2,i) && k <=n;k++){
//                System.out.println("k = " +k +": " + " index :" + (0+k-iterateStartIndex));
                bitArray[k] = bitArray[0+k-iterateStartIndex]+1;
            }
        }

        return bitArray;
    }


    public static void main(String[] args){
        Solution_338 solution = new Solution_338();

        int[] nums= new int[]{0,1,2,4,5,7};

//        int[] answer = solution.countBits(31);

        System.out.println(Arrays.toString(solution.countBits(4)));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
