package solution;//Given a string s, return true if the s can be palindrome after deleting at mos
//t one character from it. 
//
// 
// Example 1: 
//
// 
//Input: s = "aba"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
// 
//
// Example 3: 
//
// 
//Input: s = "abc"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s consists of lowercase English letters. 
// 
// Related Topics Two Pointers String Greedy 
// 👍 4313 👎 257


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_680 {
    public boolean validPalindrome(String s) {
        int i = 0,j = s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return isValidPalindrome(s,i+1,j) ||
                        isValidPalindrome(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isValidPalindrome(String s ,int i,int j){
        while(i<j){
            if(s.charAt(i) !=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args){
        Solution_680 solution = new Solution_680();

        String s= "abca";


        System.out.println(solution.validPalindrome(s));
    }




}
//leetcode submit region end(Prohibit modification and deletion)
