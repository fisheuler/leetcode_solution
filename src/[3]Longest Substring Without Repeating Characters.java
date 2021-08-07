//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 16062 👎 786


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }

        Map<Character,Integer> charPosition = new HashMap();

        int left =0, right = 0;
        int max = 0;
        for(;right<s.length();right++){
            Character ch = s.charAt(right);
            if(charPosition.containsKey(ch)) {
                left = Math.max(left, charPosition.get(ch));
            }
            charPosition.put(ch,right);
            max = Math.max(max,right-left);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
