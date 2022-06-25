package solution;//Given a string array words, return the maximum value of length(word[i]) * leng
//th(word[j]) where the two words do not share common letters. If no such two word
//s exist, return 0. 
//
// 
// Example 1: 
//
// 
//Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
//Output: 16
//Explanation: The two words can be "abcw", "xtfn".
// 
//
// Example 2: 
//
// 
//Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
//Output: 4
//Explanation: The two words can be "ab", "cd".
// 
//
// Example 3: 
//
// 
//Input: words = ["a","aa","aaa","aaaa"]
//Output: 0
//Explanation: No such pair of words.
// 
//
// 
// Constraints: 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] consists only of lowercase English letters. 
// 
// Related Topics Array String Bit Manipulation 
// 👍 1822 👎 95


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_318 {
    public int maxProduct(String[] words) {
        int width = words.length;
        int[][] wordFrequency = new int[width][26];

        for(int i=0;i<words.length;i++){
            String str = words[i];
            for(int j=0;j<str.length();j++){
                wordFrequency[i][str.charAt(j)-'a']++;
            }
        }
        int max = 0;
        for(int i=0;i<words.length;i++){
            int[] ith = wordFrequency[i];
            for(int j=i+1;j<words.length;j++){
                int[] jth = wordFrequency[j];
                boolean havecommon = false;
                for(int k=0;k<26;k++){
                    if(ith[k]>0 && jth[k]>0){
                        havecommon =true;
                        break;
                    }
                }
                if(!havecommon){
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }


    public static void main(String[] args){
        Solution_318 solution = new Solution_318();

        String[] array = {
                "abcw","baz","foo","bar","xtfn","abcdef"
        };


        System.out.println(solution.maxProduct(array));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
