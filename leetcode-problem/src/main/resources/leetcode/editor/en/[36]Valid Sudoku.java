//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be v
//alidated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 with
//out repetition. 
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily solva
//ble. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being
// modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is inval
//id.
// 
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit 1-9 or '.'. 
// 
// Related Topics Array Hash Table Matrix 
// 👍 4536 👎 673


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> haveSeen = new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    String encodeValue = '(' + board[i][j]+')';

                    if(!haveSeen.contains(encodeValue + i) && haveSeen.contains(j+encodeValue) &&
                    haveSeen.contains(i/3 + encodeValue + i%3)){
                        haveSeen.add(encodeValue + i);
                        haveSeen.add(j+encodeValue );
                        haveSeen.contains(i/3 + encodeValue + i%3))
                    }{
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
