//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
// Related Topics String 
// 👍 3141 👎 7398


import com.sun.org.apache.xpath.internal.operations.String;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*
        题解：https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution

        简单思路，就是将题目的zigzag规律进行拆分，拆分成人类能理解的两个关键步骤

        1 一个向下的字符填充步骤，填充字符数目是numRows个
        2 一个斜向上方的填充步骤，填充字符数目是numRows-2个
     */

    public String convert(String s, int numRows) {
        char[] sc = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];

        for(int i=0;i<numRows;i++){
            sb[i]=new StringBuilder();
        }

        int len = sc.length;
        int cur = 0;
        while(cur<len){
            for(int i=0;i<numRows && cur<len ;i++){
                sb[i].append(sc[cur++]);
            }

            for( int i=numRows-2;i>0 && cur<len ;i--){
                sb[i].append(sc[cur++]);
            }

        }

        StringBuilder all = new StringBuilder();
        for (StringBuilder row : sb) all.append(row);
        return all.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
