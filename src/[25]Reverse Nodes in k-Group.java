//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may b
//e changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
// 
//
// Example 4: 
//
// 
//Input: head = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range sz. 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
//
// 
//Follow-up: Can you solve the problem in O(1) extra memory space? Related Topic
//s Linked List Recursion 
// 👍 4559 👎 429


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
class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return head;
        }
        ListNode iterate = head;
        ListNode dummy = new ListNode();
        ListNode dummyEnd=dummy;
        ListNode step=new ListNode();
        ListNode stepEnd = null;
        int num=0;
        while(iterate!=null){
            if(num==k){
                dummyEnd.next = step.next;
                dummyEnd = stepEnd;
                step = new ListNode();
                stepEnd =null;
                num=0;
            }else{
                ListNode temp = iterate;
                iterate = iterate.next;
                if(stepEnd==null){
                    stepEnd = temp;
                }
                temp.next = step.next;
                step.next =temp;
                num++;
            }
        }

        if(num==k){
            dummyEnd.next = step.next;
        }else{
            if(step!=null){
                ListNode node = reverseList(step.next);
                dummyEnd.next = node;
            }
        }


        return dummy.next;

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
