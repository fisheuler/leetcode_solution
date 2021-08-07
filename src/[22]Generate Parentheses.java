//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 9130 👎 362


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_22 {

    List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        addParenthesis(sb,0,0,n);
        return result;
    }

    /*
    an example to understand this solution:
(
((
(((
((()
((())
((()))
(()
(()(
(()()
(()())
(())
(())(
(())()
()
()(
()((
()(()
()(())
()()
()()(
()()()



     */

    public void addParenthesis(StringBuilder sb,int leftCount,int rightCount,int n){
        if(sb.length()==n*2){
            result.add(sb.toString());
            return;
        }
        if(leftCount<n){

            addParenthesis(sb.append("("),leftCount+1,rightCount,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(rightCount<leftCount){
            addParenthesis(sb.append(")"),leftCount,rightCount+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
