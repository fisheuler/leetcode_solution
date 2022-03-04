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
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();

        for(int i = 1;i<=9;i++){
            result.addAll(beginWithNum(i,low,high));
        }

        Collections.sort(result);
        return result;
    }

    public List<Integer> beginWithNum(int num,int low ,int high){
        List<Integer> result = new ArrayList();
        int current = num;
        while(current<=high){
            if(validNum(current,low,high)){
                result.add(current);
            }

            if(current%10 == 9){
                break;
            }
            current = current*10 + current%10+1;
        }
        return result;
    }

    public boolean validNum(int candidate,int low ,int high ){
        return candidate>=low && candidate<=high;
    }


    public static void main(String[] args){
        Solution_1291 solution = new Solution_1291();

        System.out.println(solution.sequentialDigits(1000,13000));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
