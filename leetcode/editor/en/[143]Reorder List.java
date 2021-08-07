//You are given the head of a singly linked-list. The list can be represented as
//: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 104]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics Linked List Two Pointers Stack Recursion 
// 👍 3607 👎 157


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
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode slow = head,fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = reverseList(slow.next);

        ListNode p1 = head;
        ListNode total ;
        while(p1!=mid){
            total= p1;
            total.next = mid;

            ListNode p1Temp = p1.next;
            ListNode midTemp = mid.next;
            total.next = mid;



        }


    }

    public ListNode reverseList(ListNode listNode){
        if(listNode ==null){
            return listNode;
        }
        ListNode dummy = new ListNode();
        while(listNode!=null){

            ListNode temp = listNode;
            listNode = listNode.next;

            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
