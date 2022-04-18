package solution;//Given a positive integer n, generate an n x n matrix filled with elements from
// 1 to n2 in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics Array Matrix Simulation 
// 👍 3050 👎 168


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rStart = 0,rEnd = n-1;
        int cStart = 0,cEnd = n-1;
        int i =1;

        while(rStart<=rEnd && cStart<=cEnd){
            //填一行
            for(int k = cStart;k<=cEnd;k++){
                matrix[rStart][k] = i++;
            }
            //填一列
            for(int k = rStart+1;k<=rEnd;k++){
                matrix[k][rEnd]=i++;
            }
            // 倒序填写行
            for( int k=cEnd-1;k>=cStart;k--){
                matrix[rEnd][k]=i++;
            }

            // 倒序填写列
            for(int k=rEnd-1;k>=rStart+1;k--){
                matrix[k][cStart]=i++;
            }
            System.out.println("i=" +i);
            rStart +=1;
            rEnd -=1;
            cStart+=1;
            cEnd -=1;
        }


        return matrix;
    }



    public static void main(String[] args){
        Solution_59 solution = new Solution_59();

        int n = 5;
        int[][] matrix = solution.generateMatrix(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }


//    1,2,0
//    0,0,3
//    5,4,0

}
//leetcode submit region end(Prohibit modification and deletion)
