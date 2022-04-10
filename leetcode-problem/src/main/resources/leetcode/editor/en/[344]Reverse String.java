//Write a function that reverses a string. The input string is given as an array
// of characters s. 
//
// You must do this by modifying the input array in-place with O(1) extra memory
//. 
//
// 
// Example 1: 
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// Example 2: 
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s[i] is a printable ascii character. 
// 
// Related Topics Two Pointers String Recursion 
// 👍 4360 👎 915


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        if(s.length<=1){
            return;
        }

        int i=0,j=s.length-1;
        while(i<=j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
