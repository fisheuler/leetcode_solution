//You are given an integer num. You can swap two digits at most once to get the 
//maximum valued number. 
//
// Return the maximum valued number you can get. 
//
// 
// Example 1: 
//
// 
//Input: num = 2736
//Output: 7236
//Explanation: Swap the number 2 and the number 7.
// 
//
// Example 2: 
//
// 
//Input: num = 9973
//Output: 9973
//Explanation: No swap.
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 108 
// 
// Related Topics Math Greedy 
// 👍 1759 👎 100


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_670 {
    public int maximumSwap(int num) {
        /*
         用一个index数组来记录0-9个数字在num中的位置，
         然后从9-0开始判断：某个值能不能替换到从开始的值
         */
        StringBuilder builder = new StringBuilder(String.valueOf(num));

        int[] numMap = new int[10];

        for(int i=0;i<builder.length();i++){
            numMap[builder.charAt(i)-'0']=i;
        }

        for(int i=0;i<builder.length();i++){
            char value = builder.charAt(i);
            for(int k=9;k>=0;k--){
                if(numMap[k]>i && k > value-'0'){
                    char kth = builder.charAt(numMap[k]);
                    builder.setCharAt(i,kth);
                    builder.setCharAt(numMap[k],value);
                    return Integer.parseInt(builder.toString());
                }
            }
        }
        return num;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
