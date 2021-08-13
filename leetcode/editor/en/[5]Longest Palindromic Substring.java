//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 12585 👎 764


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();


        /*

        f(i)(j) = f(i-1)(j-1) + f[i]=f[j];
         */

        boolean[][] palindrome = new boolean[length-1][length-1];

        for(int i=0;i<length;i++){
            palindrome[i][i]=true;
        }
        int maxLength=0;
        int maxLeftIndex = 0;
        int maxRightIndex = 0;
        for(int i=0;i<s.length()/2;i++){
            for(j=0;j<i;j++){
                boolean palindrome[i-j][i+j] = palindrome[i-j+1][i+j-1] && (s.charAt(i-j) == s.charAt(i+j));
                if(palindrome[i-j][i+j]){
                    if(i-j > max){
                        maxLeftIndex = i-j;
                        maxRightIndex = i+j;
                        max = i-j;
                    }
                }

            }
        }

        return s.subString(maxLeftIndex,maxRightIndex);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
