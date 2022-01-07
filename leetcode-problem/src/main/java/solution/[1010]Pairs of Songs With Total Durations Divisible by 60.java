package solution;//You are given a list of songs where the ith song has a duration of time[i] sec
//onds. 
//
// Return the number of pairs of songs for which their total duration in seconds
// is divisible by 60. Formally, we want the number of indices i, j such that i < 
//j with (time[i] + time[j]) % 60 == 0. 
//
// 
// Example 1: 
//
// 
//Input: time = [30,20,150,100,40]
//Output: 3
//Explanation: Three pairs have a total duration divisible by 60:
//(time[0] = 30, time[2] = 150): total duration 180
//(time[1] = 20, time[3] = 100): total duration 120
//(time[1] = 20, time[4] = 40): total duration 60
// 
//
// Example 2: 
//
// 
//Input: time = [60,60,60]
//Output: 3
//Explanation: All three pairs have a total duration of 120, which is divisible 
//by 60.
// 
//
// 
// Constraints: 
//
// 
// 1 <= time.length <= 6 * 104 
// 1 <= time[i] <= 500 
// 
// Related Topics Array Hash Table Counting 
// 👍 2002 👎 94


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1010 {
    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> remainderNum = new HashMap<>();
        for(int num: time){
            int rN = remainderNum.getOrDefault(num%60,0);
            remainderNum.put(num%60,rN+1);
        }

        int num = 0;
        int zeroN = remainderNum.getOrDefault(0,0);
        num = num + getComNum(zeroN);
        int thirtyN = remainderNum.getOrDefault(30,0);
        num = num + getComNum(thirtyN);
        for(int i=1;i<=29;i++){
            int firstNum = remainderNum.getOrDefault(i,0);
            int secondNum = remainderNum.getOrDefault(60-i,0);

            num = num + firstNum*secondNum;
        }
        return num;
    }

    public static int getComNum ( int n){
        if(n==2){
            return 1;
        }
        return n*(n-1)/2;
    }

    public int numPairsDivisibleBy60_Brute_Force(int[] time) {
        int num = 0;
        for(int i =0;i<time.length;i++){
            for(int j=i+1;j<time.length;j++){
                if((time[i]+time[j])%60 == 0){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args){
        System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,40}));

    }

}
//leetcode submit region end(Prohibit modification and deletion)
