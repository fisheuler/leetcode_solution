package solution.Programming;//Given an integer array arr, and an integer target, return the number of tuples
// i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target. 
//
// As the answer can be very large, return it modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
//Output: 20
//Explanation: 
//Enumerating by the values (arr[i], arr[j], arr[k]):
//(1, 2, 5) occurs 8 times;
//(1, 3, 4) occurs 8 times;
//(2, 2, 4) occurs 2 times;
//(2, 3, 3) occurs 2 times.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,1,2,2,2,2], target = 5
//Output: 12
//Explanation: 
//arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
//We choose one 1 from [1,1] in 2 ways,
//and two 2s from [2,2,2,2] in 6 ways.
// 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 3000 
// 0 <= arr[i] <= 100 
// 0 <= target <= 300 
// 
// Related Topics Array Hash Table Two Pointers Sorting Counting 
// 👍 991 👎 154


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {



    public static void main(String[] args){
        Solution solution = new Solution();

        String s = "abbccdde efghijklm";


        System.out.println(getMaxNotRepeatedStringLength(s));


    }


    /*

        "abc  cdeef"


     */



    public static int getMaxNotRepeatedStringLength(String s){

        if(s==null || s.length()<=0){
            return 0;
        }

        Map<Character,Integer> characterIndexMap = new HashMap<>();
        int i = 0,j=0;
        int max = Integer.MIN_VALUE;
        while(j<s.length()){
            if(!characterIndexMap.containsKey(s.charAt(j))){
                characterIndexMap.put(s.charAt(j),j);
                j++;
            }else{
                max = Math.max(max,(j-i));
                int index = characterIndexMap.get(s.charAt(j));
                for(int k=i;k<=index;k++){
                    characterIndexMap.remove(s.charAt(k));
                }
                i = index+1;
                characterIndexMap.put(s.charAt(j),j);
                j++;
            }
        }

        return Math.max(max,(j-i));
    }







}
//leetcode submit region end(Prohibit modification and deletion)
