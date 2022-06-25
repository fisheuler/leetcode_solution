package solution;//You are given an integer array coins representing coins of different denominat
//ions and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If th
//at amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics Array Dynamic Programming Breadth-First Search 
// 👍 11245 👎 270


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_322{
    public int coinChange_2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;

        for(int j=0;j<coins.length;j++){
            System.out.println("j:"+j +" coins[j]:"+coins[j]);
            for(int i=0;i<=amount;i++){
                if(i-coins[j]>=0){
                    System.out.println("dp"+i +" before:"+dp[i]);

                    System.out.println(i +":"+dp[i] +" " + i +"-"+coins[j]+"="+(i-coins[j])+" :"+(dp[i-coins[j]]+1));

                    System.out.println("dp[i-coins[j]" +"=" +"dp["+i+"-"+coins[j]+"]" +"="+"dp["+(i-coins[j])+"]"+"="+dp[i-coins[j]]);
                    System.out.println("dp["+(i-coins[j])+"] +1 = " +(dp[i-coins[j]] +1));
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                    System.out.println("dp"+i +" after:"+dp[i]);
                    System.out.println();
                }
            }
        }
        return dp[amount] > amount ?-1:dp[amount];
    }


    Map<Integer,Integer> lru = new HashMap<>();

    public int coinChange(int[] coins,int amount){

        if(lru.containsKey(amount)){
            return lru.get(amount);
        }
        int min = Integer.MAX_VALUE;
        if(amount==0){
            min = 0;
        }else if (amount < 0){

        }else {
            for(int coin: coins){
                int coinChange = coinChange(coins,amount-coin);
                if(coinChange== -1){
                    continue;
                }
                min = Math.min(min,coinChange+1);
            }
        }
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        if(amount>=0){
            lru.put(amount,min);
        }

        
        return min;
    }




    public static void main(String[] args){
        Solution_322 solution = new Solution_322();

        int[] nums= new int[]{1,2,5};
        int val = 11;
//        int[] answer = solution.countBits(31);

        System.out.println(solution.coinChange_2(nums,val));
    }






























}
//leetcode submit region end(Prohibit modification and deletion)
