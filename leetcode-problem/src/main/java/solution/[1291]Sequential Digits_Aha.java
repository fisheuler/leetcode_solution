package solution;//An integer has sequential digits if and only if each digit in the number is on
//e more than the previous digit. 
//
// Return a sorted list of all the integers in the range [low, high] inclusive t
//hat have sequential digits. 
//
// 
// Example 1: 
// Input: low = 100, high = 300
//Output: [123,234]
// Example 2: 
// Input: low = 1000, high = 13000
//Output: [1234,2345,3456,4567,5678,6789,12345]
// 
// 
// Constraints: 
//
// 
// 10 <= low <= high <= 10^9 
// 
// Related Topics Enumeration 
// 👍 890 👎 68


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1291_Aha {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] allNums = {12,23,34,45,56,67,78,89,
                123,234,345,456,567,678,789,
                1234,2345,3456,4567,5678,6789,
                12345,23456,34567,45678,56789,
                123456,234567,345678,456789,
                1234567,2345678,3456789,
                12345678,23456789,
                123456789};
        List<Integer> res = new ArrayList<>();
        int n = allNums.length;
        for (int i = 0; i < n; i++) {
            if (allNums[i] < low) continue;
            if (allNums[i] > high) break;
            res.add(allNums[i]);
        }
        return res;
    }



    public static void main(String[] args){
        Solution_1291 solution = new Solution_1291();

        System.out.println(solution.sequentialDigits(1000,13000));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
