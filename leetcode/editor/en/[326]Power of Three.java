//Given an integer n, return true if it is a power of three. Otherwise, return f
//alse. 
//
// An integer n is a power of three, if there exists an integer x such that n ==
// 3x. 
//
// 
// Example 1: 
// Input: n = 27
//Output: true
// Example 2: 
// Input: n = 0
//Output: false
// Example 3: 
// Input: n = 9
//Output: true
// Example 4: 
// Input: n = 45
//Output: false
// 
// 
// Constraints: 
//
// 
// -231 <= n <= 231 - 1 
// 
//
// 
//Follow up: Could you solve it without loops/recursion? Related Topics Math Rec
//ursion 
// 👍 395 👎 49


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        while(n>=3){
            if(n%3==0){
                n = n/3;
            }else{
                return false;
            }
        }
        if(n==1){
            return true;
        }

        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
