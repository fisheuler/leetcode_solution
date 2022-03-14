//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math Recursion 
// 👍 16867 👎 3583


//leetcode submit region begin(Prohibit modification and deletion)

import solution.ListNode;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode iterate = dummy;
        int carry = 0;
        while(l1!=null || l2!=null){
            int value1 = l1!=null?l1.val:0;
            int value2 = l2!=null?l2.val:0;
            int value = value1 + value2+carry;
            carry = value/10;
            value = value%10;
            iterate.next = new ListNode(value);
            iterate = iterate.next;
            l1= l1!=null?l1.next:null;
            l2= l2!=null?l2.next:null;
        }
        if(carry>0){
            iterate.next = ListNode(carry);
        }

        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
