//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 
// 👍 6905 👎 556


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList();
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        combination(sb,digits,0);
        return result;
    }

    public void combination(StringBuilder sb,String digits,int index){
        if(index+1==digits.length()){
            result.add(sb.toString());
            return ;
        }
        String mapping = KEYS[digits.charAt(index)-'0'];
        int keyIndex = digits.charAt(index)-'0';
        for(int i=0;i<mapping.length();i++){
            combination(sb.append(mapping.charAt(i)),digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
