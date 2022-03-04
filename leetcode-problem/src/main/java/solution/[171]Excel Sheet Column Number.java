package solution;//Given a string columnTitle that represents the column title as appear in an Ex
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
class Solution_171 {
    public int titleToNumber(String columnTitle) {

        int sum = 0;
        for(int i=0;i<columnTitle.length();i++){
            sum = sum*26 +(columnTitle.charAt(i)-'A' +1);
        }

        return sum;
    }

    public int titleToNumber_2(String columnTitle) {

        char[] charValue = columnTitle.toCharArray();

        int sum = 0;
        for(char value: charValue){
            sum = sum*26 +(value-'A' +1);
        }
        return sum;
    }

    public static void main(String[] args){
        Solution_171 solution = new Solution_171();

        String value = "ZY"; // 6

        System.out.println(solution.titleToNumber(value));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
