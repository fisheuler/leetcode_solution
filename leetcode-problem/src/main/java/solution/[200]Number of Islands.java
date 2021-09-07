package solution;//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '
//0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find Matri
//x 
// 👍 9457 👎 260


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_200 {
    public int numIslands(char[][] grid) {
        int width = grid.length;
        int length = grid[0].length;
        int count=0;
        for(int i=0;i<width;i++){
            for(int j=0;j<length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid ,int i,int j){
        if(i<0 || i>grid.length-1 || j <0 || j>grid[0].length-1){
            return ;
        }
        if(grid[i][j]==1){
            grid[i][j]=0;
            bfs(grid,i+1,j);
            bfs(grid,i-1,j);
            bfs(grid,i,j+1);
            bfs(grid,i,j-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
