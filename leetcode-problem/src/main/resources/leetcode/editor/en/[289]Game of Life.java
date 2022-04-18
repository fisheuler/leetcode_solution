//According to Wikipedia's article: "The Game of Life, also known simply as Life
//, is a cellular automaton devised by the British mathematician John Horton Conwa
//y in 1970." 
//
// The board is made up of an m x n grid of cells, where each cell has an initia
//l state: live (represented by a 1) or dead (represented by a 0). Each cell inter
//acts with its eight neighbors (horizontal, vertical, diagonal) using the followi
//ng four rules (taken from the above Wikipedia article): 
//
// 
// Any live cell with fewer than two live neighbors dies as if caused by under-p
//opulation. 
// Any live cell with two or three live neighbors lives on to the next generatio
//n. 
// Any live cell with more than three live neighbors dies, as if by over-populat
//ion. 
// Any dead cell with exactly three live neighbors becomes a live cell, as if by
// reproduction. 
// 
//
// The next state is created by applying the above rules simultaneously to every
// cell in the current state, where births and deaths occur simultaneously. Given 
//the current state of the m x n grid board, return the next state. 
//
// 
// Example 1: 
//
// 
//Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// 
//
// Example 2: 
//
// 
//Input: board = [[1,1],[1,0]]
//Output: [[1,1],[1,1]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 25 
// board[i][j] is 0 or 1. 
// 
//
// 
// Follow up: 
//
// 
// Could you solve it in-place? Remember that the board needs to be updated simu
//ltaneously: You cannot update some cells first and then use their updated values
// to update other cells. 
// In this question, we represent the board using a 2D array. In principle, the 
//board is infinite, which would cause problems when the active area encroaches up
//on the border of the array (i.e., live cells reach the border). How would you ad
//dress these problems? 
// 
// Related Topics Array Matrix Simulation 
// 👍 3746 👎 395


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1}{-1,-1},{-1,1},{1,-1}};

    int ALIVE = 1;
    int DEAD = 0;
    int DEADTOALIVE = 2;
    int ALIVETODEAD = 3;
    public void gameOfLife(int[][] board) {
        for(int r = 0;r<board.length;r++){
            for(int c =0;c<board[0].length;c++){

                int alive = 0;
                for(int[] direction:directions){
                    alive += isAlive(board,r,c,direction);
                }

                if(board[r][c] == DEAD){
                    if(alive == 3){
                        board[r][c] =DEADTOALIVE;
                    }
                }else{
                    if(alive !=2 && alive !=3){
                        board[r][c] = ALIVETODEAD;
                    }
                }
            }
        }


        for(int r = 0;r <board.length;r++){
            for(int c =0;c<board[0].length;c++){
                if(board[r][c] == DEADTOALIVE){
                    board[r][c] = ALIVE;
                }else if (board[r][c] == ALIVETODEAD){
                    board[r][c] =DEAD;
                }
            }
        }
    }


    private int isAlive(int[][] board,int r, int c,int[] direction){
        boolean alive = 0;
        r +=direction[0];
        c +=direction[1];
        if(r>=0 && r<board.length && c>=0 && c<board[0].length){
            if(board[r][c] == ALIVE || board[r][c] == ALIVETODEAD){
                alive =1;
            }
        }
        return alive;
    }

























}
//leetcode submit region end(Prohibit modification and deletion)
