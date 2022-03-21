//Given two integer arrays pushed and popped each with distinct values, return t
//rue if this could have been the result of a sequence of push and pop operations 
//on an initially empty stack, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//Output: true
//Explanation: We might do the following sequence:
//push(1), push(2), push(3), push(4),
//pop() -> 4,
//push(5),
//pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// Example 2: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//Output: false
//Explanation: 1 cannot be popped before 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= pushed.length <= 1000 
// 0 <= pushed[i] <= 1000 
// All the elements of pushed are unique. 
// popped.length == pushed.length 
// popped is a permutation of pushed. 
// 
// Related Topics Array Stack Simulation 
// 👍 1942 👎 35


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*

        [1,2,3,4,5], popped = [4,5,3,2,1]

        two patterns:
        first:      4,5
        we iterate both of the array index until not the same

        second :    3,2,1

        // we pop the stack & increase the popped array index



    */

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack();

        int i=0,j=0;

        for(;i<pushed.length;i++){
            if(pushed[i]!=popped[j]){
                stack.push(pushed[i]);
            }else{
                while (!stack.isEmpty()&& (stack.peek()==popped[j])){
                    stack.pop();
                    j++;
                }
            }
        }
        if(stack.size()>0){
            return false;
        }
        return true;

    }


























    public boolean validateStackSequences_2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int j=0;
        for(int x: pushed){
            stack.push(x);
            while(stack.size()>0 && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.size() ==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
