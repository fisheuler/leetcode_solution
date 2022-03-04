//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length won't exceed 10^4. 
// 
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge Sor
//t 
// 👍 8159 👎 376


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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        if(lists.length ==2){
            return mergeTwoList(lists[0],lists[1]);
        }
        ListNode[] one = new ListNode[lists.length/2];
        ListNode[] two = new ListNode[lists.length - lists.length/2];

        //(src   , src-offset  , dest , offset, count)
        System.arraycopy(lists,  0, one, 0     , one.length);
        System.arraycopy(lists, one.length, two, 0     , two.length);


        ListNode left = mergeKLists(one),right = mergeKLists(two);
        return mergeTwoList(left,right);
    }



    public ListNode mergeTwoList(ListNode first ,ListNode second){
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while(first!=null && second !=nulll){
            if(first.val <= second.val){
                temp.next = first;
                first = first.next;
            }else{
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        if(first!=null){
            temp.next = first;
        }else if (second!=null){
            temp.next = second;
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
