package solution;//You are given an array representing a row of seats where seats[i] = 1 represen
//ts a person sitting in the ith seat, and seats[i] = 0 represents that the ith se
//at is empty (0-indexed). 
//
// There is at least one empty seat, and at least one person sitting. 
//
// Alex wants to sit in the seat such that the distance between him and the clos
//est person to him is maximized. 
//
// Return that maximum distance to the closest person. 
//
// 
// Example 1: 
//
// 
//Input: seats = [1,0,0,0,1,0,1]
//Output: 2
//Explanation: 
//If Alex sits in the second open seat (i.e. seats[2]), then the closest person 
//has distance 2.
//If Alex sits in any other open seat, the closest person has distance 1.
//Thus, the maximum distance to the closest person is 2.
// 
//
// Example 2: 
//
// 
//Input: seats = [1,0,0,0]
//Output: 3
//Explanation: 
//If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats a
//way.
//This is the maximum distance possible, so the answer is 3.
// 
//
// Example 3: 
//
// 
//Input: seats = [0,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 2 <= seats.length <= 2 * 104 
// seats[i] is 0 or 1. 
// At least one seat is empty. 
// At least one seat is occupied. 
// 
// Related Topics Array 
// 👍 2420 👎 159


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_849 {
    /*
        考虑两种情况
        1 被分割成连续空间
     */
    public int maxDistToClosest(int[] seats) {
        int maxEmptyLength = 0;
        int emptyStart ;
        int emptyEnd = 0;
        int i = 0;
        if(seats[i]==0){
            while(seats[i]==0){
                i++;
            };
            maxEmptyLength = i;
            emptyEnd = i;

        }



        for(;i<=seats.length-1;i++){
            if(seats[i] == 1){
                emptyStart = emptyEnd;
                emptyEnd = i;
                int emptyLength = emptyEnd-emptyStart;
                if(emptyLength/2> maxEmptyLength){
                    maxEmptyLength = emptyLength/2;
                }
            }
        }
        if(seats[i-1] == 0){
            maxEmptyLength = maxEmptyLength>(i-1-emptyEnd)?maxEmptyLength:(i-1-emptyEnd);
        }
        return maxEmptyLength ;
    }

    public static void main(String[] args){
        Solution_849 solution = new Solution_849();
//        int[] seat = new int[]{1,0,0,0,1,0,1};
//        int[] seat = new int[]{1,0,0,0};
//        int[] seat = new int[]{0,0,1};
        int[] seat = new int[]{1,0,1};
        System.out.println(solution.maxDistToClosest(seat));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
