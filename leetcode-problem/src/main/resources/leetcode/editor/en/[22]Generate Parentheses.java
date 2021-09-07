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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        addParenthesis(sb,0,0,n);
        return result;
    }

    public void addParenthesis(StringBuilder sb,int leftCount,int rightCount,int n){
        if(sb.length()==n*2){
            return;
        }

        if(leftCount == rightCount){
            result.add(sb.toString());
        }

        if(leftCount<n){
            sb.add("(");
            addParenthesis(sb.add("("),leftCount+1,rightCount,n);
            sb.remotevLastChar();
        }

        if(rightCount<leftCount){
            addParenthesis(sb.add(")"),leftCount,rightCount+1,n);
            sb.removeLastChar();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
