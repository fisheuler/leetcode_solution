package solution;//Given string num representing a non-negative integer num, and an integer k, re
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


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_402 {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()){
            return "";
        }

        Stack<Character> stack = new Stack();

        int i=0;
        while(i<num.length()){
            char ch = num.charAt(i);
            while(k>0 && !stack.isEmpty() && stack.peek()>ch){
                stack.pop();
                k = k -1;
            }
            stack.push(ch);
        }

        while(k>0){
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
