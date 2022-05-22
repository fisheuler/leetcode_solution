//You are given an integer array coins representing coins of different denominat
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


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;

        for(int j=0;j<coins.length;j++){
            for(int i=0;i<=amount;i++){
                if(i-coins[j]>=0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ?-1:dp[amount];
    }


    Map<Integer,Integer> lru = new HashMap<>();
    public int coinChange(int[] coins,int amount){

        if(lru.contains(amount)){
            return lru.get(amount);
        }
        int min = Integer.MAX_VALUE;
        if(amount==0){
            min = 0;
        }else if (amount < 0){

        }else {
            for(int coin: coins){
                min = Math.min(min,coinChange(coins,amount-coin)+1);
            }
        }

        lru.set(amount,min);

        return min;
    }





























}
//leetcode submit region end(Prohibit modification and deletion)
