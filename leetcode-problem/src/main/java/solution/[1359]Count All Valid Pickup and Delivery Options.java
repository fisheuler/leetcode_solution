package solution;//Given n orders, each order consist in pickup and delivery services.
//
// Count all valid pickup/delivery possible sequences such that delivery(i) is a
//lways after of pickup(i). 
//
// Since the answer may be too large, return it modulo 10^9 + 7. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: 1
//Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: 6
//Explanation: All possible orders: 
//(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and 
//(P2,D2,P1,D1).
//This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2
//.
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: 90
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 500 
// 
// Related Topics Math Dynamic Programming Combinatorics 
// 👍 564 👎 81


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1359 {
    public int countOrders(int n) {
        long ans = 1;
        int MOD = 1_000_000_007;

        for (int i = 1; i <= n; ++i) {
            // Ways to arrange all pickups, 1*2*3*4*5*...*n
            ans = ans * i;
            // Ways to arrange all deliveries, 1*3*5*...*(2n-1)
            ans = ans * (2 * i - 1);
            ans %= MOD;
        }

        return (int)ans;
    }


    public static void main(String[] args){
        Solution_1359 solution = new Solution_1359();

        System.out.println(solution.countOrders(3));
    }



}
//leetcode submit region end(Prohibit modification and deletion)