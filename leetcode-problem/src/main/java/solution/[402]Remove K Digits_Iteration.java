package solution;//Given string num representing a non-negative integer num, and an integer k, re
//turn the smallest possible integer after removing k digits from num. 
//
// 
// Example 1: 
//
// 
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 w
//hich is the smallest.
// 
//
// Example 2: 
//
// 
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output 
//must not contain leading zeroes.
// 
//
// Example 3: 
//
// 
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing
// which is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= num.length <= 105 
// num consists of only digits. 
// num does not have any leading zeros except for the zero itself. 
// 
// Related Topics String Stack Greedy Monotonic Stack 
// 👍 3779 👎 160


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_402_2 {
    /*

    https://leetcode.com/problems/remove-k-digits/discuss/88708/Straightforward-Java-Solution-Using-Stack

       先找一下算法
       归纳法：
       1 先移除一个元素，我们从左往右，找到第一个peak点，然后将其删除即可
       2 循环K次

       这个循环算法效率比较低，因为每次循环都有可能需要把之前已经比较过的数据重新比较一下，
       我们可以考虑用一种数据结构把这种情况记录下来，每次判断都是从这个地方进行下一次数据的判断。


     */
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        for(int i=0;i<k;i++){
            sb = removeOnedigits(sb);
        }
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0){
            sb.append("0");
        }
        return sb.toString();
    }


    public String removeKdigits_2(String num , int k){

        StringBuilder sb = new StringBuilder(num);
        int nextIndex = 0;
        while(k>0){
            if(nextIndex == sb.length()-1){
                while(k>0){
                    if(sb.length()>0){
                        sb.deleteCharAt(sb.length()-1);
                        k--;
                    }else{
                        break;
                    }

                }
            }
            if(sb.length() == 0){
                break;
            }
            while((nextIndex+1)<sb.length() && sb.charAt(nextIndex)<=sb.charAt(nextIndex+1)){
                nextIndex++;
            }
            while( k>0 && nextIndex>=0 && (nextIndex+1 <sb.length()) &&
                    sb.charAt(nextIndex)>sb.charAt(nextIndex+1)){
                sb.deleteCharAt(nextIndex);
                k--;
                nextIndex --;
                if(nextIndex <0){
                    nextIndex =0;
                };
            }
        }

        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0){
            sb.append("0");
        }

        return sb.toString();
    }


    public StringBuilder  removeOnedigits(StringBuilder num){
        if(num.length()<1){
            return num;
        }
        int i = 0;
        for(;i<num.length();i++){
            if(i>=num.length()-1){
                break;
            }
            if(num.charAt(i) >num.charAt(i+1)){
                break;
            }
        }
        return num.deleteCharAt(i);
    }






    public static void main(String[] args){
        Solution_402_2 solution = new Solution_402_2();
        // [1,3,1,5,4]
        // 3,1,4,1,5
        // [1,1,1,1,1]
        //
        int[] seat = new int[]{1,1,1,1,1};

        String num = "112";
        int k = 1;

//        String num = "9";
//        int k = 1;

//        String num = "10";
//        int k = 2;

//        String num = "10200";
//        int k = 1;

//        "10200"
//        1

        System.out.println(solution.removeKdigits_2(num,k));
    }



}
//leetcode submit region end(Prohibit modification and deletion)
