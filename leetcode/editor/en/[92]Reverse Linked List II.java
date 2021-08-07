//Given the head of a singly linked list and two integers left and right where l
//eft <= right, reverse the nodes of the list from position left to position right
//, and return the reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass? Related Topics Linked List 
// 👍 4404 👎 223


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



    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head ==null){
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next =head;
        ListNode prev = dummy;
        for(int i=0;i<left-1;i++){
            prev = prev.next;
        }

        ListNode start = prev.next;

        ListNode current = start.next;


        /*

 2 -5

1   2   3   4   5   6

1   3   2   4   5   6

1   4   3   2   5   6

1   5   4   3   2   6

 */

        for(int i=0;i<right-left;i++){

            start.next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = start.next;

        }

        return dummy.next;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
