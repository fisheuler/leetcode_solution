//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics Linked List Two Pointers 
// 👍 4228 👎 1246


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
    public ListNode rotateRight(ListNode head, int k) {
        // valid check
        if(k<=0){
            return head;
        }
        if(head ==null){
            return head;
        }

        // step 1

        // get length of the list
        ListNode iterate = head;
        int length = 0;

        while(iterate!=null){
            length++;
            iterate =iterate.next;
        }

        // get the rotate num we need
        int rotate = k%length;



        if(rotate<=0){
            return head;
        }

        // step 2

        iterate = head;
        ListNode rotateHead = head;

        while(rotate>1){
            rotateHead = rotateHead.next;
            rotate--;
        }

        while(rotateHead.next!=null && rotateHead.next.next!=null){
            iterate = iterate.next;
            rotateHead = rotateHead.next;
        }


        /*

            take rotate n = 3 as example,when the above while loop
            ended, we got the two pointer as below:


     head-->...--> 2 --> 3 ---> 4 ---->  5 ----> 6


                         ^               ^
                         |               |
                       iterate         rotateHead


         */

        // mv the rotate list range to head of the list
        rotateHead.next.next =head;
        ListNode newHead = iterate.next;
        iterate.next = null;



        return newHead;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
