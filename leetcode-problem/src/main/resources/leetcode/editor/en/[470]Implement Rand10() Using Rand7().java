//Given the API rand7() that generates a uniform random integer in the range [1,
// 7], write a function rand10() that generates a uniform random integer in the ra
//nge [1, 10]. You can only call the API rand7(), and you shouldn't call any other
// API. Please do not use a language's built-in random API. 
//
// Each test case will have one internal argument n, the number of times that yo
//ur implemented function rand10() will be called while testing. Note that this is
// not an argument passed to rand10(). 
//
// Follow up: 
//
// 
// What is the expected value for the number of calls to rand7() function? 
// Could you minimize the number of calls to rand7()? 
// 
//
// 
// Example 1: 
// Input: n = 1
//Output: [2]
// Example 2: 
// Input: n = 2
//Output: [2,8]
// Example 3: 
// Input: n = 3
//Output: [3,8,10]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 105 
// 
// Related Topics Math Rejection Sampling Randomized Probability and Statistics 
//
// 👍 741 👎 249


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int value = 49;
        while(value>=40){
            int first = rand7();
            int second = rand7();

            value = (first-1) *7 + second-1;
        }
        return value%10+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
