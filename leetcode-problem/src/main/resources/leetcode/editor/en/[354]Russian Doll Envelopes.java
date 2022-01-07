//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] r
//epresents the width and the height of an envelope. 
//
// One envelope can fit into another if and only if both the width and height of
// one envelope are greater than the other envelope's width and height. 
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one in
//side the other). 
//
// Note: You cannot rotate an envelope. 
//
// 
// Example 1: 
//
// 
//Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] 
//=> [5,4] => [6,7]).
// 
//
// Example 2: 
//
// 
//Input: envelopes = [[1,1],[1,1],[1,1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= envelopes.length <= 5000 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 104 
// 
// Related Topics Array Binary Search Dynamic Programming Sorting 
// 👍 2706 👎 66


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
     Solution:
     https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation
     1.Sort the array. Ascend on width and descend on height if width are same.
     2.Find the longest increasing subsequence based on height.


     */
    public int maxEnvelopes(int[][] envelopes) {
        if( envelopes == null || envelopes[0].length ==0
        || envelopes[0]==null || envelopes[0].length !=2 ){
            return 0;
        }

        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] arr1,int[] arr2){
                if(arr1[0] == arr2[0]){
                    return arr2[1] - arr1[1];
                }else{
                    return arr1[0] - arr2[0];
                }
            }
        });

        int dp[]  = new int[envelopes.length];

        int len = 0;

        for( int[] envelope: envelopes){
            int index = Arrays.binarySearch(dp,0,len,envelope[1]);
            if(index < 0){
                index = -(index+1);
            }
            dp[index] = envelope[1];
            if(index == len){
                len++;
            }
        }

        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
