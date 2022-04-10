package solution;//You are given the head of a linked list, and an integer k.
//
// Return the head of the linked list after swapping the values of the kth node 
//from the beginning and the kth node from the end (the list is 1-indexed). 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
//Output: [7,9,6,6,8,7,3,0,9,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 105 
// 0 <= Node.val <= 100 
// 
// Related Topics Linked List Two Pointers 
// 👍 1813 👎 77


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
class Solution_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null){
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head;
        int iter = k;
        while(iter>1){
            secondNode = secondNode.next;
            iter--;
        }

        ListNode startNode = secondNode;

        while(secondNode.next!=null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        int temp = startNode.val;
        startNode.val = firstNode.val;
        firstNode.val = temp;
        return head;

    }

    public static void main(String[] args){
        Solution_1721 solution = new Solution_1721();

//        int[] array = new int[]{1,2,3,4,5};
        int[] array = new int[]{7,9,6,6,7,8,3,0,9,5};
        ListNode list = createNode(array);
        printNode(list);
        printNode(solution.swapNodes(list,2));


    }

    public static ListNode createNode(int[] array){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        for( int item: array){
            ListNode node = new ListNode(item);
            prev.next = node;
            prev = node;
        }
        return dummy.next;
    }

    public static void printNode(ListNode node){
        while(node!=null){
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
