package solution;//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division, and mod operator. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, 8.345 would be truncated to 8, and -2.7335 would be tr
//uncated to -2. 
//
// Return the quotient after dividing dividend by divisor. 
//
// Note: Assume we are dealing with an environment that could only store integer
//s within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if 
//the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the q
//uotient is strictly less than -231, then return -231. 
//
// 
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = 3.33333.. which is truncated to 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = -2.33333.. which is truncated to -2.
// 
//
// 
// Constraints: 
//
// 
// -231 <= dividend, divisor <= 231 - 1 
// divisor != 0 
// 
// Related Topics Math Bit Manipulation 
// 👍 2950 👎 10238


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_29 {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int res = 0;

        int sign = (dividend<0) ^(divisor<0) ? -1:1;

        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        while(dvs <= dvd){
            long temp = dvs,mul =1;
            while(dvd >= temp<<1){
                temp<<=1;
                mul<<=1;
            }
            dvd -=temp;
            res+=mul;
        }

        return sign ==1 ?res:-res;
    }






    public static void main(String[] args){
        Solution_29 solution = new Solution_29();
        solution.divide(-2147483648,
                2);
    }





}
//leetcode submit region end(Prohibit modification and deletion)
