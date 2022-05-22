//Given an integer n, return the number of strings of length n that consist only
// of vowels (a, e, i, o, u) and are lexicographically sorted. 
//
// A string s is lexicographically sorted if for all valid i, s[i] is the same a
//s or comes before s[i+1] in the alphabet. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: 5
//Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i"
//,"o","u"].
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: 15
//Explanation: The 15 sorted strings that consist of vowels only are
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
//Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet
//.
// 
//
// Example 3: 
//
// 
//Input: n = 33
//Output: 66045
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 50 
// 
// Related Topics Dynamic Programming 
// 👍 1860 👎 43


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918507/Java-DP-O(n)-time-Easy-to-understand


just think about the mathematical induction
if we know all the string of len k, so the string of len k + 1 will be
1 add a before all string of len k
2 add e before the string of len k, which is starts with or after e
3 add i before the string of len k, which starts with or after i
4 add o before the string of len k, which starts with or after o
5 add u before the string of len k, which starts with or after u

     */
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        while(n > 1) {
            // add new char before prev string
            a = (a + e + i + o + u); // a, e, i, o, u -> aa, ae, ai, ao, au
            e = (e + i + o + u); // e, i, o, u -> ee, ei, eo, eu
            i = (i + o + u); // i, o, u -> ii, io, iu
            o = (o + u); // o, u -> oo, ou
            u = (u);; // u -> uu
            n--;
        }

        return a + e + i + o + u;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
