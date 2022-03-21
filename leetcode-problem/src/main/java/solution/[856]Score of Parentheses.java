package solution;//Given a balanced parentheses string s, return the score of the string.
//
// The score of a balanced parentheses string is based on the following rule: 
//
// 
// "()" has score 1. 
// AB has score A + B, where A and B are balanced parentheses strings. 
// (A) has score 2 * A, where A is a balanced parentheses string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: s = "(())"
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: s = "()()"
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 2 <= s.length <= 50 
// s consists of only '(' and ')'. 
// s is a balanced parentheses string. 
// 
// Related Topics String Stack 
// 👍 3225 👎 95


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_856 {
    public int scoreOfParentheses_2(String s) {

        Deque<Character> stack = new ArrayDeque();
        int score = 0;
        int subSum = 1;
        int i=0;
        int length=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                stack.push('(');
                length++;
                i++;
            }else{
                if(length>0){
                    while((i<s.length()) && s.charAt(i)==')' && (length>0) ){
                        subSum = subSum*2;
                        stack.pop();
                        i++;
                        length--;
                    }

                    length=0;


                    score = score + subSum/2;
                    subSum = 1;

                }else{
                    score = score*2;
                    stack.pop();
                    i++;
                }

            }

        }

        return score;
    }


    public int scoreOfParentheses(String s) {
        return scoreOfRange(s,0,s.length());
    }

    public int scoreOfRange(String s ,int i,int j){
        int ans =0,bal = 0;

        for(int k = i;k<j;++k){
            if(s.charAt(k)=='('){
                bal = bal+1;
            }else{
                bal = bal-1;
            }
            if(bal==0){
                if(k-i == 1){
                    ans ++;
                }else{
                    ans += scoreOfRange(s,i,k);
                }
                k = k+1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution_856 solution = new Solution_856();

        String s ;

//        s = "(()(()))";

//        s = "()()";

//        s = "(())";

        s = "()";

        // ""


        System.out.println(solution.scoreOfParentheses(s));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
