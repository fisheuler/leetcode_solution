//Given a string columnTitle that represents the column title as appear in an Ex
//cel sheet, return its corresponding column number. 
//
// For example: 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
// Example 1: 
//
// 
//Input: columnTitle = "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: columnTitle = "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: columnTitle = "ZY"
//Output: 701
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle consists only of uppercase English letters. 
// columnTitle is in the range ["A", "FXSHRXW"]. 
// 
// Related Topics Math String 
// 👍 2503 👎 240


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
        char[] charValue = columnTitle.toCharArray();

        int sum = 0;
        for(char value: charValue){
            sum = sum*26 + (value-'A' +1);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
