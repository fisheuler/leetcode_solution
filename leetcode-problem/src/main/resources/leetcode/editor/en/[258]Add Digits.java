//Given an integer num, repeatedly add all its digits until the result has only 
//one digit, and return it. 
//
// 
// Example 1: 
//
// 
//Input: num = 38
//Output: 2
//Explanation: The process is
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2 
//Since 2 has only one digit, return it.
// 
//
// Example 2: 
//
// 
//Input: num = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 231 - 1 
// 
//
// 
// Follow up: Could you do it without any loop/recursion in O(1) runtime? 
// Related Topics Math Simulation Number Theory 
// 👍 1652 👎 1471


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        String value = String.valueOf(num);
        if(value.length()<2){
            return num;
        }

        int sum = 0;
        for(int i=0;i<value.length();i++){
            sum +=value.charAt(i)-'0';
        }
        return addDigits(sum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
