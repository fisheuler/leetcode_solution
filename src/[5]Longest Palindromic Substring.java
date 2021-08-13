//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 12585 👎 764


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_5 {
    int start = 0, end = 0,max=0;
    public  String longestPalindrome(String s) {

        for(int i=0;i<s.length();i++){
            /*
                 <- a ->
             */
            expand(s,i,i);

            /*
                <- a,a ->
             */
            expand(s,i,i+1);
        }

        return s.substring(start,end);
    }

    public  void expand(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        int length = j-i-1;
        if(length>max){
            max = length;
            start=i+1;
            end =j-1;
        }
    }


    public String longestPalindrome_2(String s) {
        int length = s.length();

        /*
        f(i)(j) = f(i-1)(j-1) + f[i]=f[j];
         */

        boolean[][] palindrome = new boolean[length][length];

        for(int i=0;i<length;i++){
            palindrome[i][i]=true;
        }
        int maxLength=0;
        int maxLeftIndex = 0;
        int maxRightIndex = 0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<i;j++){
                if(i-j>=0 && i+j<s.length()){

                    palindrome[i-j][i+j] = palindrome[i-j+1][i+j-1] && (s.charAt(i-j) == s.charAt(i+j));
                    if(palindrome[i-j][i+j]){
                        if(2*j+1 > maxLength){
                            maxLeftIndex = 2*j+1;
                            maxRightIndex = i+j;
                            maxLength = i-j;
                        }
                    }
                }

                if(i-j>=0 && i+j+1<s.length()){
                    if(j==0){
                        palindrome[i-j][i+j+1] = s.charAt(i) == s.charAt(i+1);
                    }else{
                        palindrome[i-j][i+j+1] = palindrome[i-j+1][i+j] && s.charAt(i-j) == s.charAt(i+j+1);
                    }

                    if(palindrome[i-j][i+j+1]){
                        if(2*j+2 > maxLength){
                            maxLeftIndex = 2*j+2;
                            maxRightIndex = i+j;
                            maxLength = i-j;
                        }
                    }
                }


            }
        }

        return s.substring(maxLeftIndex,maxRightIndex);

    }


}
//leetcode submit region end(Prohibit modification and deletion)
