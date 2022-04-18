//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, and /. Each operand may be an integer or another
// expression. 
//
// Note that division between two integers should truncate toward zero. 
//
// It is guaranteed that the given RPN expression is always valid. That means th
//e expression would always evaluate to a result, and there will not be any divisi
//on by zero operation. 
//
// 
// Example 1: 
//
// 
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
//
// 
// Constraints: 
//
// 
// 1 <= tokens.length <= 104 
// tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the 
//range [-200, 200]. 
// 
// Related Topics Array Math Stack 
// 👍 2864 👎 614


import java.util.HashSet;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length<=0){
            return -1;
        }

        Stack<Integer> expr = new Stack<>();
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        for(String token: tokens){
            if(ops.contains(token)){
                int second = expr.pop();
                int first = expr.pop();
                if(token =="+"){
                    expr.push(first+second);
                }else if (token =="-"){
                    expr.push(first-second);
                }else if (token =="*"){
                    expr.push(first*second);
                }else if (token =="/"){
                    expr.push(first/second);
                }else{
                    System.out.println("error "+token);
                }
            }else{
                expr.push(Integer.parseInt(token));
            }
        }

        return expr.pop();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
