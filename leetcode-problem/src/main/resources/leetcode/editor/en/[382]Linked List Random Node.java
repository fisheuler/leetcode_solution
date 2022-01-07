//Given a singly linked list, return a random node's value from the linked list.
// Each node must have the same probability of being chosen. 
//
// Implement the Solution class: 
//
// 
// Solution(ListNode head) Initializes the object with the integer array nums. 
// int getRandom() Chooses a node randomly from the list and returns its value. 
//All the nodes of the list should be equally likely to be choosen. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
//[[[1, 2, 3]], [], [], [], [], []]
//Output
//[null, 1, 3, 2, 2, 3]
//
//Explanation
//Solution solution = new Solution([1, 2, 3]);
//solution.getRandom(); // return 1
//solution.getRandom(); // return 3
//solution.getRandom(); // return 2
//solution.getRandom(); // return 2
//solution.getRandom(); // return 3
//// getRandom() should return either 1, 2, or 3 randomly. Each element should h
//ave equal probability of returning.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the linked list will be in the range [1, 104]. 
// -104 <= Node.val <= 104 
// At most 104 calls will be made to getRandom. 
// 
//
// 
// Follow up: 
//
// 
// What if the linked list is extremely large and its length is unknown to you? 
//
// Could you solve this efficiently without using extra space? 
// 
// Related Topics Linked List Math Reservoir Sampling Randomized 
// 👍 1165 👎 287


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    蓄水池抽样算法

    https://leetcode.com/problems/linked-list-random-node/solution/

    转换为array，然后随机数来搞定，这个是对于n是确定的且比较小的情况比较合适

    有几个缺点：
    1 It requires some space to keep the pool of elements
    for sampling, which does not meet the constraint asked
    in the follow-up question, i.e. a solution of constant space.

    2 It cannot cope with the scenario that we have a list
    with ever-growing elements, i.e. we don't have unlimited
    memory to hold all the elements. For example, we have a stream
    of numbers, and we would like to pick a random number
    at any given moment. With the above naive solution,
    we would have to keep all the numbers in the memory,
    which is not scalable.


    如果候选集合数量是未知的，则应该如何处理。可以将问题转换一个思路，
    候选集合数量不知晓，但是要筛选的数据集合是知晓的，从已知的候选集合
    里进行操作。

    原理解释：

    https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling

    Problem:
    Choose k entries from n numbers. Make sure each number
    is selected with the probability of k/n

    Basic idea:
    1.Choose 1, 2, 3, ..., k first and put them into the reservoir.
    2.For k+1, pick it with a probability of k/(k+1), and randomly
    replace a number in the reservoir.
    3.For k+i, pick it with a probability of k/(k+i), and randomly
    replace a number in the reservoir.
    4.Repeat until k+i reaches n

    Proof:
    1.1 For k+i, the probability that it is selected and will replace a number
        in the reservoir is k/(k+i)

    1.2 For a number in the reservoir before (let's say X), the probability
        that it keeps staying in the reservoir is
          1.2.1 P(X was in the reservoir last time) × P(X is not replaced by k+i)
          1.2.2 = P(X was in the reservoir last time) × (1 - P(k+i is selected and replaces X))
          1.2.3 = k/(k+i-1) × （1 - k/(k+i) × 1/k）
          1.2.4 = k/(k+i)

    1.3 When k+i reaches n, the probability of each number staying
        in the reservoir is k/n



     */

    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        if(head == null){
            return -1;
        }

        int value = -1;
        int num = 1;
        ListNode temp = head;
        while(temp!=null){
            double random = Math.random()*num;
            if(random<1.0){
                value = temp.val;
            }
            num++;
            temp = temp.next;
        }
        return value;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
