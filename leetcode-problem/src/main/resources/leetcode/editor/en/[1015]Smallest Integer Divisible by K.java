//Given a positive integer k, you need to find the length of the smallest positi
//ve integer n such that n is divisible by k, and n only contains the digit 1. 
//
// Return the length of n. If there is no such n, return -1. 
//
// Note: n may not fit in a 64-bit signed integer. 
//
// 
// Example 1: 
//
// 
//Input: k = 1
//Output: 1
//Explanation: The smallest answer is n = 1, which has length 1.
// 
//
// Example 2: 
//
// 
//Input: k = 2
//Output: -1
//Explanation: There is no such positive integer n divisible by 2.
// 
//
// Example 3: 
//
// 
//Input: k = 3
//Output: 3
//Explanation: The smallest answer is n = 111, which has length 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 105 
// 
// Related Topics Hash Table Math 
// 👍 479 👎 480


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*

    题解：https://leetcode.com/problems/smallest-integer-divisible-by-k/discuss/260875/Python-O(K)-with-Detailed-Explanations

    1用余数法进行loop迭代
    2余数迭代过程中出现了loop之后，不能被整除（K 次）

     */
    public int smallestRepunitDivByK(int k) {
        int remain = k%10;
        if( remain == 2 || remain == 4 || remain == 6 || remain == 8){
            return -1;
        }

        int n=1;
        remain = 1;
        for(int i=0;i<k;i++){

            remain = remain%k;
            if(remain == 0){
                return n;
            }else{
                remain = remain*10 +1;
                n = n+1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
