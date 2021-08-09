//Given the head of a linked list and a value x, partition it such that all node
//s less than x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the t
//wo partitions. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [2,1], x = 2
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 200]. 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics Linked List Two Pointers 
// 👍 2593 👎 435


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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }

        ListNode dummyLittle = new ListNode(-1);
        ListNode littleEnd = dummyLittle;

        ListNode dummyGreate = new ListNode(-1);
        ListNode greateEnd = dummyGreate;
        while(head!=null){
            if(head.val<x){
                littleEnd.next  = head;
                littleEnd = littleEnd.next;
            }else{
                greateEnd.next = head;
                greateEnd = greateEnd.next;
            }
            head = head.next;
        }
        greateEnd.next=null;
        littleEnd.next = dummyGreate.next;
        return dummyLittle.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
