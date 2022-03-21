package solution;//Design a stack-like data structure to push elements to the stack and pop the m
//ost frequent element from the stack. 
//
// Implement the FreqStack class: 
//
// 
// FreqStack() constructs an empty frequency stack. 
// void push(int val) pushes an integer val onto the top of the stack. 
// int pop() removes and returns the most frequent element in the stack.
// 
// If there is a tie for the most frequent element, the element closest to the s
//tack's top is removed and returned. 
// 
// 
// 
//
// 
// Example 1: 
//
// 
//Input
//["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "p
//op", "pop"]
//[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
//Output
//[null, null, null, null, null, null, null, 5, 7, 5, 4]
//
//Explanation
//FreqStack freqStack = new FreqStack();
//freqStack.push(5); // The stack is [5]
//freqStack.push(7); // The stack is [5,7]
//freqStack.push(5); // The stack is [5,7,5]
//freqStack.push(7); // The stack is [5,7,5,7]
//freqStack.push(4); // The stack is [5,7,5,7,4]
//freqStack.push(5); // The stack is [5,7,5,7,4,5]
//freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [
//5,7,5,7,4].
//freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is clos
//est to the top. The stack becomes [5,7,5,4].
//freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [
//5,7,4].
//freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is c
//losest to the top. The stack becomes [5,7].
// 
//
// 
// Constraints: 
//
// 
// 0 <= val <= 109 
// At most 2 * 104 calls will be made to push and pop. 
// It is guaranteed that there will be at least one element in the stack before 
//calling pop. 
// 
// Related Topics Hash Table Stack Design Ordered Set 
// 👍 2582 👎 43


import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class FreqStack{

    class Node{
        Node next;
        Node prev;
        int value;
        int epoch;
    }

    class ValueInfo{
        int val;
        int sameValueNum=0;
        Stack<Node> nodePoint = new Stack<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ValueInfo valueInfo = (ValueInfo) o;
            return val == valueInfo.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    Node head ,tail;
    int epoch;
    HashMap<Integer,ValueInfo> hashMap;

    PriorityQueue<ValueInfo> valueInfoPriorityQueue ;


    class ValueInfoComparator implements Comparator<ValueInfo> {

        @Override
        public int compare(ValueInfo o1, ValueInfo o2) {
            if(o1.sameValueNum==o2.sameValueNum){
                return o2.nodePoint.peek().epoch - o1.nodePoint.peek().epoch;
            }else{
                return o2.sameValueNum - o1.sameValueNum;
            }
        }
    }

    public FreqStack() {
        head = tail = new Node();
        head.next = tail;
        tail.prev = head;
        valueInfoPriorityQueue = new PriorityQueue<ValueInfo>(new ValueInfoComparator());
        epoch = 0;
        hashMap = new HashMap<>();
    }
    
    public void push(int val) {
        Node node = new Node();
        node.value = val;
        epoch = epoch +1;
        node.epoch = epoch;

        node.prev = tail.prev;

        tail.prev.next = node;

        node.next = tail;
        tail.prev = node;

        ValueInfo valueInfo = hashMap.get(val);
        if(valueInfo == null){
            valueInfo = new ValueInfo();
            valueInfo.val = val;
            valueInfo.sameValueNum=1;
            valueInfo.nodePoint.push(node);
            hashMap.put(val,valueInfo);
            valueInfoPriorityQueue.add(valueInfo);
        }else{
            valueInfo.sameValueNum+=1;
            valueInfo.nodePoint.push(node);
            valueInfoPriorityQueue.remove(valueInfo);
            valueInfoPriorityQueue.add(valueInfo);
        }
    }

    public boolean isEmpty(){
        return head.next == tail;
    }
    
    public int pop() {
        ValueInfo valueInfo = valueInfoPriorityQueue.poll();
        int val = valueInfo.val;
        valueInfo.sameValueNum -=1;
        Node node = valueInfo.nodePoint.pop();

        // 删除node在list中的位置

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;

        if(valueInfo.sameValueNum==0){
            // 彻底删除
            hashMap.remove(val);
        }else{
            //更新在valueInfoPriorityQueue中的位置
            valueInfoPriorityQueue.add(valueInfo);
        }

        return val;
    }


    public static void main(String[] args){

        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]

        while(!freqStack.isEmpty()){
            System.out.println(freqStack.pop());
        }
//        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
//        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
//        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
//        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
//

    }






}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)
