//Given a binary tree 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no ne
//xt right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,null,7]
//Output: [1,#,2,3,#,4,5,7,#]
//Explanation: Given the above binary tree (Figure A), your function should popu
//late each next pointer to point to its next right node, just like in Figure B. T
//he serialized output is in level order as connected by the next pointers, with '
//#' signifying the end of each level.
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 6000]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow-up: 
//
// 
// You may only use constant extra space. 
// The recursive approach is fine. You may assume implicit stack space does not 
//count as extra space for this problem. 
// 
// Related Topics Linked List Tree Depth-First Search Breadth-First Search Binar
//y Tree 
// 👍 3703 👎 237


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;

class Solution {
    public Node connect(Node root) {
        if(root ==null){
            return node;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(queue.size()>0){
            int size = queue.size();
            Node prev=null;
            for(int i=0;i<size;i++){
                Node node = queue.pop();
                if(node.left!=null){
                    queue.push(node.left);
                }
                if(node.right!=null){
                    queue.push(node.right);
                }
                if(prev==null){
                    prev = node;
                }else{
                    prev.next=node;
                }
            }
        }

        return root;
    }






















}
//leetcode submit region end(Prohibit modification and deletion)
