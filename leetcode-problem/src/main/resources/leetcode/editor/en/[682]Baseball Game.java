//You are keeping score for a baseball game with strange rules. The game consist
//s of several rounds, where the scores of past rounds may affect future rounds' s
//cores. 
//
// At the beginning of the game, you start with an empty record. You are given a
// list of strings ops, where ops[i] is the ith operation you must apply to the re
//cord and is one of the following: 
//
// 
// An integer x - Record a new score of x. 
// "+" - Record a new score that is the sum of the previous two scores. It is gu
//aranteed there will always be two previous scores. 
// "D" - Record a new score that is double the previous score. It is guaranteed 
//there will always be a previous score. 
// "C" - Invalidate the previous score, removing it from the record. It is guara
//nteed there will always be a previous score. 
// 
//
// Return the sum of all the scores on the record. 
//
// 
// Example 1: 
//
// 
//Input: ops = ["5","2","C","D","+"]
//Output: 30
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"2" - Add 2 to the record, record is now [5, 2].
//"C" - Invalidate and remove the previous score, record is now [5].
//"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//The total sum is 5 + 10 + 15 = 30.
// 
//
// Example 2: 
//
// 
//Input: ops = ["5","-2","4","C","D","9","+","+"]
//Output: 27
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"-2" - Add -2 to the record, record is now [5, -2].
//"4" - Add 4 to the record, record is now [5, -2, 4].
//"C" - Invalidate and remove the previous score, record is now [5, -2].
//"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
//"9" - Add 9 to the record, record is now [5, -2, -4, 9].
//"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
//"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
//The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
// 
//
// Example 3: 
//
// 
//Input: ops = ["1"]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= ops.length <= 1000 
// ops[i] is "C", "D", "+", or a string representing an integer in the range [-3
// * 104, 3 * 104]. 
// For operation "+", there will always be at least two previous scores on the r
//ecord. 
// For operations "C" and "D", there will always be at least one previous score 
//on the record. 
// 
// Related Topics Array Stack Simulation 
// 👍 1032 👎 1378


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calPoints(String[] ops) {
        if(ops.length<1){
            return 0;
        }
        Stack<String> stack = new LinkedList<>();

        for(String op:ops){
            if(op =="C"){
                stack.pop();
            }else if (op =="+"){
                Integer v1 = Integer.parseInt(stack.pop());
                Integer v2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(v1+v2));
            }else if (op == "D"){
                Integer v1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(v1*2));
            }else{
                stack.push(op);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
