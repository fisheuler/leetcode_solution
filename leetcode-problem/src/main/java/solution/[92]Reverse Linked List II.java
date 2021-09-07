package solution;//Given the head of a singly linked list and two integers left and right where l
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
class Solution_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null){
            return head;
        }
        if(left == right){
            return head;
        }

        ListNode iterate = head;

        int leftIterate =1;
        ListNode leftPrev=null;
        if(left ==1){

        }else{
            while(iterate!=null && (leftIterate+1)!=left){
                iterate = iterate.next;
                leftIterate++;
            }
            leftPrev = iterate;
            iterate = iterate.next;
            leftIterate++;
        }




        ListNode dummy = new ListNode();
        ListNode dummyEnd=null;
        while(iterate!=null && leftIterate!=right){
            if(dummyEnd==null){
                dummyEnd = iterate;
            }
            ListNode temp =iterate;
            iterate = iterate.next;
            temp.next = dummy.next;
            dummy.next = temp;

            leftIterate++;
        }

        ListNode rightNext = iterate.next;

        ListNode temp = iterate;

        temp.next = dummy.next;
        dummy.next = temp;

        if(leftPrev==null){
            head = dummy.next;
        }else{
            leftPrev.next = dummy.next;
        }

        dummyEnd.next = rightNext;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
