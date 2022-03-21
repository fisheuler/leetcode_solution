//In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halv
//es of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on 
//each half of the tile.) 
//
// We may rotate the ith domino, so that tops[i] and bottoms[i] swap values. 
//
// Return the minimum number of rotations so that all the values in tops are the
// same, or all the values in bottoms are the same. 
//
// If it cannot be done, return -1. 
//
// 
// Example 1: 
//
// 
//Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
//Output: 2
//Explanation: 
//The first figure represents the dominoes as given by tops and bottoms: before 
//we do any rotations.
//If we rotate the second and fourth dominoes, we can make every value in the to
//p row equal to 2, as indicated by the second figure.
// 
//
// Example 2: 
//
// 
//Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
//Output: -1
//Explanation: 
//In this case, it is not possible to rotate the dominoes to make one row of val
//ues equal.
// 
//
// 
// Constraints: 
//
// 
// 2 <= tops.length <= 2 * 104 
// bottoms.length == tops.length 
// 1 <= tops[i], bottoms[i] <= 6 
// 
// Related Topics Array Greedy 
// 👍 1672 👎 211


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] number = new int[6];

        for(int i=0;i<tops.length;i++){
            if(tops[i] == bottoms[i]){
                number[tops[i]]++;
            }else{
                number[tops[i]]++;
                number[bottoms[i]]++;
            }
        }
        boolean haveAnswer=false;
        int num;
        for(int i=0;i<number.length;i++){
            if(number[i] == tops.length){
                haveAnswer=true;
                num = number[i];
            }
        }

        if(!haveAnswer){
            return -1;
        }

        int topNum=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]==num[i]){
                topNum++;
            }
        }

        return topNum<tops.length-topNum?topNum:tops.length-topNum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
