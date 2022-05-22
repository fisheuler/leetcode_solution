package solution;//Given a string n representing an integer, return the closest integer (not incl
//uding itself), which is a palindrome. If there is a tie, return the smaller one.
// 
//
// The closest is defined as the absolute difference minimized between two integ
//ers. 
//
// 
// Example 1: 
//
// 
//Input: n = "123"
//Output: "121"
// 
//
// Example 2: 
//
// 
//Input: n = "1"
//Output: "0"
//Explanation: 0 and 2 are the closest palindromes but we return the smallest wh
//ich is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n.length <= 18 
// n consists of only digits. 
// n does not have leading zeros. 
// n is representing an integer in the range [1, 1018 - 1]. 
// 
// Related Topics Math String 
// 👍 477 👎 1127


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_564 {
    public String nearestPalindromic(String n) {

        int length = n.length();

        if(length<2){
            return String.valueOf(Integer.parseInt(n)-1);
        }

        String nine = "";
        for(int i=0;i<length-1;i++){
            nine =nine+"9";
        }

        String oneToOne="1";

        for(int i=0;i<length-1;i++){
            oneToOne= oneToOne+"0";
        }
        oneToOne = oneToOne+"1";

        /*
           0,1,2

           0,1, 2,3

         */

        String leftHalf = "";
        Character ch=null;
        if(length%2==0){
            leftHalf = n.substring(0,length/2-1);
            ch = n.charAt(length/2-1);
        }else{
            leftHalf = n.substring(0,length/2);
            ch = n.charAt(length/2);
        }

        Set<String> candidate = new HashSet<>();
        String right = new StringBuffer(leftHalf).reverse().toString();
        Set<Character> valid = new HashSet<>();

        valid.add(ch);
        if(ch =='0'){
            valid.add('1');
        }else if (ch=='9'){
            valid.add('8');
        }else{
            valid.add(--ch);
            ch++;
            valid.add(++ch);
        }

        if(n.length()%2==0){
            //偶数
            for(Character can: valid){
                candidate.add(leftHalf + can+can+right);
            }

        }else{
            //偶数
            for(Character can: valid){
                candidate.add(leftHalf + can+ right);
            }
        }

        candidate.add(oneToOne);
        candidate.add(nine);
        Long orig = Long.parseLong(n);
        long abs = Integer.MAX_VALUE;
        String candidateV="";
        for(String value: candidate){
            System.out.println(value);
            long v = Long.parseLong(value);
            long vabs = Math.abs(v-orig);
            if(vabs<abs && v!=orig){
                candidateV = value;
                abs=Math.abs(v-orig);
            }else if (vabs==abs && v <Long.parseLong(candidateV)){
                candidateV=value;
            }
        }
        return candidateV;

    }

    public static void main(String[] args){
        Solution_564 solution = new Solution_564();

        /*
        10
        1283
         */
        System.out.println(solution.nearestPalindromic("1283"));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
