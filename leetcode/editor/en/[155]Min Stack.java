//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// Implement the MinStack class: 
//
// 
// MinStack() initializes the stack object. 
// void push(val) pushes the element val onto the stack. 
// void pop() removes the element on the top of the stack. 
// int top() gets the top element of the stack. 
// int getMin() retrieves the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// -231 <= val <= 231 - 1 
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks. 
// At most 3 * 104 calls will be made to push, pop, top, and getMin. 
// 
// Related Topics Stack Design 
// 👍 5653 👎 509


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> minStack = new Stack();

    /** initialize your data structure here. */
    public MinStack() {
    /*
    另一个栈存储从元素开头的递减子序列。
     */
    }

    public void push(int val) {
        stack1.push(val);
        if(minStack.size()==0){
            minStack.push(val);
        }else{
            if(minStack.peek()>=val){
                minStack.push(val);
            }
        }

    }

    public void pop() {
        int value = stack1.pop();
        if(minStack.peek()==value){
            minStack.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
