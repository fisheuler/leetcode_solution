//Given a linked list, return the node where the cycle begins. If there is no cy
//cle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. N
//ote that pos is not passed as a parameter. 
//
// Notice that you should not modify the linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
// Related Topics Hash Table Linked List Two Pointers 
// 👍 4734 👎 340


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode slow = head;
        ListNode quick = head;

        boolean haveCircle=false;
        while(quick != null && quick.next !=null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                haveCircle = true;
                break;
            }
        }

        if(!haveCircle){
            return null;
        }

        ListNode circleNode = slow.next;

        int circleCount = 1;

        while(circleNode!=slow){
            circleCount++;
            circleNode = circleNode.next;
        }

        /*

         Plength = 从head 到circle_head 的步数

         Pcircle = circle环的数目

         两个指针：
         P1:从head 开始先走circle步

         然后P1和P2再往下走Plength步，一定相交。

         */

        ListNode p1 = head;
        while(circleCount>0){
            p1 = p1.next;
            circleCount--;
        }

        ListNode p2 = head;

        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
