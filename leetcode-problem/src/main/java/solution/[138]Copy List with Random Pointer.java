package solution;//A linked list of length n is given such that each node contains an additional
//random pointer, which could point to any node in the list, or null. 
//
// Construct a deep copy of the list. The deep copy should consist of exactly n 
//brand new nodes, where each new node has its value set to the value of its corre
//sponding original node. Both the next and random pointer of the new nodes should
// point to new nodes in the copied list such that the pointers in the original li
//st and copied list represent the same list state. None of the pointers in the ne
//w list should point to nodes in the original list. 
//
// For example, if there are two nodes X and Y in the original list, where X.ran
//dom --> Y, then for the corresponding two nodes x and y in the copied list, x.ra
//ndom --> y. 
//
// Return the head of the copied linked list. 
//
// The linked list is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where: 
//
// 
// val: an integer representing Node.val 
// random_index: the index of the node (range from 0 to n-1) that the random poi
//nter points to, or null if it does not point to any node. 
// 
//
// Your code will only be given the head of the original linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// Example 2: 
//
// 
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
// 
//
// Example 3: 
//
// 
//
// 
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 1000 
// -104 <= Node.val <= 104 
// Node.random is null or is pointing to some node in the linked list. 
// 
// Related Topics Hash Table Linked List 
// 👍 7533 👎 938


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Solution_138 {

    public Map<Node,Node> o2n = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }

        Node dummy = new Node(0);
        Node temp = dummy,iterate = head;
        while(iterate!=null){
            Node newNode = new Node(iterate.val);
            o2n.put(iterate,newNode);
            temp.next = newNode;
            temp = temp.next;
            iterate = iterate.next;
        }

        iterate = head;
        while(iterate!=null){

            Node newNode = o2n.get(iterate);
            newNode.next = o2n.get(iterate.next);
            newNode.random = o2n.get(iterate.random);

            iterate = iterate.next;
        }

        return dummy.next;

    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args){
        Solution_138 solution = new Solution_138();

        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node2.random = node1;


        printValue(solution.copyRandomList(node1));
    }

    private static void printValue(Node node){
        System.out.println("node" +"\t" + "node.val" +"\t"+ "node.next"+ "\t" + "node.random");
        while(node!=null){
            System.out.println(node +" " + node.val +" "+ node.next+ " " + node.random);
            node = node.next;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
