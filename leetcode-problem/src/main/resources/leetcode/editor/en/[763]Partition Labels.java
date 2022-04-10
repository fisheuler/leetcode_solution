//You are given a string s. We want to partition the string into as many parts a
//s possible so that each letter appears in at most one part. 
//
// Note that the partition is done so that after concatenating all the parts in 
//order, the resultant string should be s. 
//
// Return a list of integers representing the size of these parts. 
//
// 
// Example 1: 
//
// 
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it split
//s s into less parts.
// 
//
// Example 2: 
//
// 
//Input: s = "eccbbbbdec"
//Output: [10]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
// Related Topics Hash Table Two Pointers String Greedy 
// 👍 6959 👎 261


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] last=new int[27];

        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a'] = i;
        }

        int j=0,anchor = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            j = Math.max(j,last[s.charAt(i)]-'a');
            if( i == j){
                ans.add(i-anchor+1);
                anchor = i+1;
            }
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
