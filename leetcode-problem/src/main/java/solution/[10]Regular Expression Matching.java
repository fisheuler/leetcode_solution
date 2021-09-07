package solution;//Given an input string s and a pattern p, implement regular expression matching
// with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a pr
//evious valid character to match. 
// 
// Related Topics String Dynamic Programming Recursion 
// 👍 6364 👎 907


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_10 {
    public boolean isMatch(String s, String p) {
        /*

        根据第二个字符是否是*号，分情况讨论

        1 第二个字符是*号
           1.1 前面一个字符匹配情况
           可以匹配上： 例如 a   a*  | a .*

           a  a* -> <s,p+2> || <s+1,p+2> || <s+1,p>

           a .*  -> <s,p+2> || <s+1,p+2> || <s+1,p>



           1.2 前面一个字符不能匹配
           例如 b   a*   ->  <s,p+2>

        2 第二个字符不是*号

          2.1 前面一个字符可以匹配
          a  a -> <s+1,p+1>
          a  . -> <s+1,p+1>


          2.2 前面一个字符不匹配

          b a  -> false


         */
        return match(s,0,p,0);
    }


    public boolean match(String s ,int sp,String p,int pp){
        int slength = s.length();
        int plength = p.length();
        if(sp > slength || pp >plength){
            return false;
        }

        if(sp ==slength && pp == plength){
            return true;
        }

        if(pp==plength){
            return false;
        }


        if((pp+1<plength) && p.charAt(pp+1)=='*'){
            if(isCharMath(s,sp,p,pp)){
                boolean firstResult = match(s,sp+1,p,pp+2);
                boolean secondResult = match(s,sp,p,pp+2);
                boolean thirdResult = match(s,sp+1,p,pp);

                return firstResult || secondResult || thirdResult;
            }else{
                return match(s,sp,p,pp+2);
            }
        }else{
            if(isCharMath(s,sp,p,pp)){
                return match(s,sp+1,p,pp+1);
            }else{
                return false;
            }
        }

    }

    public boolean isCharMath(String s,int sp,String p, int pp){
        if(sp >=s.length()){
            return false;
        }
        if(pp >= p.length()){
            return false;
        }
        char schar = s.charAt(sp);
        char pchar = p.charAt(pp);
        if(schar == pchar || pchar == '.'){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution_10 solution_10 = new Solution_10();
        System.out.println(solution_10.isMatch("aa","a*"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
