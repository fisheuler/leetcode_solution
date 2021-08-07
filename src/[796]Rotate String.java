//Given two strings s and goal, return true if and only if s can become goal aft
//er some number of shifts on s. 
//
// A shift on s consists of moving the leftmost character of s to the rightmost 
//position. 
//
// 
// For example, if s = "abcde", then it will be "bcdea" after one shift. 
// 
//
// 
// Example 1: 
// Input: s = "abcde", goal = "cdeab"
//Output: true
// Example 2: 
// Input: s = "abcde", goal = "abced"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s and goal consist of lowercase English letters. 
// 
// Related Topics String String Matching 
// 👍 1278 👎 74


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_796 {
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int length = s.length();
        for(int i=0;i<s.length();i++){
            int j=0;
            for(;j<s.length();j++){
                char sChar = s.charAt((i+j)%length);
                char gChar = goal.charAt((j));
                if(sChar != gChar){
                    break;
                }
            }
            if(j==s.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        boolean result = rotateString("abcde","cdeab");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
