//Given a string n representing an integer, return the closest integer (not incl
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

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String nearestPalindromic(String n) {

        int length = n.length();

        if(length<2){
            return n;
        }

        String nine = "";
        for(int i=0;i<length-1;i++){
            nine =nine+"9";
        }

        String oneToOne="1";

        for(int i=0;i<length-2;i++){
            oneToOne+"0";
        }
        oneToOne = oneToOne+"1";

        /*
           0,1,2

           0,1,2,3

         */

        String leftHalf = n.substring(0,(length+1)/2);

        Set<String> candidate = new HashSet<>();
        Char ch = leftHalf.charAt(leftHalf.length()-1);
        String leftWithouLast = leftHalf.substring(0,leftHalf.length()-1);
        String right = new StringBuffer(leftWithouLast).reverse().toString();
        Set<Character> valid = new HashSet<>();
        valid.add(ch);
        if(ch =='0'){
            valid.add("1");
        }else if (ch=='9'){
            valid.add('8');
        }else{
            valid.add(ch--);
            valid.add(ch++);
        }

        if(leftHalf.length()%2==0){
            //偶数
            for(Character can: valid){
                candidate.add(leftWithouLast + can+can+right);
            }

        }else{
            //偶数
            for(Character can: valid){
                candidate.add(leftWithouLast + can+ right);
            }
        }

        candidate.add(oneToOne);
        candidate.add(nine);
        Long orig = Long.parseLong(n);
        int abs = Integer.MAX_VALUE;
        String candidateV="";
        for(String value: candidate){
            long v = Long.parseLong(value);
            if(Math.abs(v-orig)>abs){
                candidateV = v;
            }
        }
        return candidateV;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
