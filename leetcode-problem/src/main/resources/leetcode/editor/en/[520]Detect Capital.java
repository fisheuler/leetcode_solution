//We define the usage of capitals in a word to be right when one of the followin
//g cases holds: 
//
// 
// All letters in this word are capitals, like "USA". 
// All letters in this word are not capitals, like "leetcode". 
// Only the first letter in this word is capital, like "Google". 
// 
//
// Given a string word, return true if the usage of capitals in it is right. 
//
// 
// Example 1: 
// Input: word = "USA"
//Output: true
// Example 2: 
// Input: word = "FlaG"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= word.length <= 100 
// word consists of lowercase and uppercase English letters. 
// 
// Related Topics String 
// 👍 1055 👎 324


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {

        int capitalNum = 0;

        boolean firstCapital = capital(word.charAt(0));

        for(int i=0;i<word.length();i++){
            if(capital(word.charAt(i))){
                capitalNum++;
            }
        }

        if ( capitalNum == 0 || capitalNum == word.length()){
            return true;
        }
        return firstCapital && (capitalNum==1);
    }

    public boolean capital(char ch){
        return ch >='A' && ch <='Z';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
