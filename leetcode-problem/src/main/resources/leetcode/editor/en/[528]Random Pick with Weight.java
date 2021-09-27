//You are given an array of positive integers w where w[i] describes the weight 
//of ith index (0-indexed). 
//
// We need to call the function pickIndex() which randomly returns an integer in
// the range [0, w.length - 1]. pickIndex() should return the integer proportional
// to its weight in the w array. For example, for w = [1, 3], the probability of p
//icking the index 0 is 1 / (1 + 3) = 0.25 (i.e 25%) while the probability of pick
//ing the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%). 
//
// More formally, the probability of picking index i is w[i] / sum(w). 
//
// 
// Example 1: 
//
// 
//Input
//["Solution","pickIndex"]
//[[[1]],[]]
//Output
//[null,0]
//
//Explanation
//Solution solution = new Solution([1]);
//solution.pickIndex(); // return 0. Since there is only one single element on t
//he array the only option is to return the first element.
// 
//
// Example 2: 
//
// 
//Input
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//Output
//[null,1,1,1,1,0]
//
//Explanation
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // return 1. It's returning the second element (index = 
//1) that has probability of 3/4.
//solution.pickIndex(); // return 1
//solution.pickIndex(); // return 1
//solution.pickIndex(); // return 1
//solution.pickIndex(); // return 0. It's returning the first element (index = 0
//) that has probability of 1/4.
//
//Since this is a randomization problem, multiple answers are allowed so the fol
//lowing outputs can be considered correct :
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//and so on.
// 
//
// 
// Constraints: 
//
// 
// 1 <= w.length <= 10000 
// 1 <= w[i] <= 10^5 
// pickIndex will be called at most 10000 times. 
// 
// Related Topics Math Binary Search Prefix Sum Randomized 
// 👍 1482 👎 3113


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
https://leetcode.com/problems/random-pick-with-weight/discuss/671445/Question-explained

解释如下：
for weights [1, 4, 5]
10% chances of getting index 0
40% chances of getting index 1
50% chances of getting index 2.
Choose a random number between 0 to 1.
Cumulative probabilities [0.1, 0.5, 1.0]
If random is between 0 - 0.1, then return index 0.
If it is between 0.1 - 0.5, then return index 1.
If it is between 0.5 - 1.0, then return index 2.

That's why we used cumulative probabilities.
Iterate through probabilities, return index where random < probabilities[i].

So, to effectively search that range we use binary search.



     */
    private double[] cummulateProbalities;
    public Solution(int[] w) {
        this.cummulateProbalities = new double[w.length];
        int sum = 0;
        for(int weight: w){
            sum = sum + weight;
        }
        int cummulate = 0;
        for(int i=0;i<w.length;i++){
            cummulate = cummulate+w[i];
            cummulateProbalities[i] = (double)cummulate/sum;
        }

    }
    
    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(cummulateProbalities,Math.random()))-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
