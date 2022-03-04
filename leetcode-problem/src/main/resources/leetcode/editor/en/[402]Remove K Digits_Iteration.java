//Given string num representing a non-negative integer num, and an integer k, re
//turn the smallest possible integer after removing k digits from num. 
//
// 
// Example 1: 
//
// 
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 w
//hich is the smallest.
// 
//
// Example 2: 
//
// 
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output 
//must not contain leading zeroes.
// 
//
// Example 3: 
//
// 
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing
// which is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= num.length <= 105 
// num consists of only digits. 
// num does not have any leading zeros except for the zero itself. 
// 
// Related Topics String Stack Greedy Monotonic Stack 
// 👍 3779 👎 160


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*

    https://leetcode.com/problems/remove-k-digits/discuss/88708/Straightforward-Java-Solution-Using-Stack

       先找一下算法
       归纳法：
       1 先移除一个元素，我们从左往右，找到第一个peak点，然后将其删除即可
       2 循环K次
     */
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        for(int i=0;i<k;i++){
            sb = removeOnedigits(sb);
        }
        return sb.toString();
    }




    public StringBuilder  removeOnedigits(StringBuilder num){
        for(int i =0;i<num.length();i++){
            if(i ==num.length()){
                break;
            }
            if(num.charAt(i) >num.charAt(i+1)){
                break;
            }
        }
        return num.deleteCharAt(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
