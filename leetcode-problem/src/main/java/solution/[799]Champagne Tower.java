package solution;//We stack glasses in a pyramid, where the first row has 1 glass, the second row
// has 2 glasses, and so on until the 100th row. Each glass holds one cup of champ
//agne. 
//
// Then, some champagne is poured into the first glass at the top. When the topm
//ost glass is full, any excess liquid poured will fall equally to the glass immed
//iately to the left and right of it. When those glasses become full, any excess c
//hampagne will fall equally to the left and right of those glasses, and so on. (A
// glass at the bottom row has its excess champagne fall on the floor.) 
//
// For example, after one cup of champagne is poured, the top most glass is full
//. After two cups of champagne are poured, the two glasses on the second row are 
//half full. After three cups of champagne are poured, those two cups become full 
//- there are 3 full glasses total now. After four cups of champagne are poured, t
//he third row has the middle glass half full, and the two outside glasses are a q
//uarter full, as pictured below. 
//
// 
//
// Now after pouring some non-negative integer cups of champagne, return how ful
//l the jth glass in the ith row is (both i and j are 0-indexed.) 
//
// 
// Example 1: 
//
// 
//Input: poured = 1, query_row = 1, query_glass = 1
//Output: 0.00000
//Explanation: We poured 1 cup of champange to the top glass of the tower (which
// is indexed as (0, 0)). There will be no excess liquid so all the glasses under 
//the top glass will remain empty.
// 
//
// Example 2: 
//
// 
//Input: poured = 2, query_row = 1, query_glass = 1
//Output: 0.50000
//Explanation: We poured 2 cups of champange to the top glass of the tower (whic
//h is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as
// (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, an
//d each will get half cup of champange.
// 
//
// Example 3: 
//
// 
//Input: poured = 100000009, query_row = 33, query_glass = 17
//Output: 1.00000
// 
//
// 
// Constraints: 
//
// 
// 0 <= poured <= 109 
// 0 <= query_glass <= query_row < 100 
// Related Topics Dynamic Programming 
// 👍 1728 👎 92


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] matrix = new double[102][102];

        matrix[0][0] = poured;

        for(int r = 0; r<=query_row;++r){
            for( int c = 0 ;c<=r; ++c){
                if(matrix[r][c] > 1){
                    matrix[r+1][c] += (matrix[r][c] -1)/2.0 ;
                    matrix[r+1][c+1] += (matrix[r][c] -1)/2.0 ;
                    matrix[r][c]=1;
                }
            }
        }

        return matrix[query_row][query_glass];
    }

    public static void main(String[] args){
        Solution_799 solution = new Solution_799();

        System.out.println(solution.champagneTower(2,1,1));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
