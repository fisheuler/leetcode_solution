//Given the root of a binary tree, flatten the tree into a "linked list": 
//
// 
// The "linked list" should use the same TreeNode class where the right child po
//inter points to the next node in the list and the left child pointer is always n
//ull. 
// The "linked list" should be in the same order as a pre-order traversal of the
// binary tree. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related 
//Topics Linked List Stack Tree Depth-First Search Binary Tree 
// 👍 5104 👎 425


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        /*
        用一个head指针存储拉直的链表的头指针
        然后（右子树，左子树，root)次序往head头部递归加元素即可。

         */
        flattern(root,null);

    }

    public TreeNode flattern(TreeNode tree,TreeNode head){
        if(tree==null){
            return head;
        }
        TreeNode rightNode = flattern(tree.right,head);
        TreeNode leftNode = flattern(tree.left,rightNode);
        tree.right = leftNode;
        tree.left = null;
        return tree;
    }


    public void flatten(TreeNode root) {

        preOrder(root,null);

    }

    public TreeNode preOrder(TreeNode tree,TreeNode last){
        if(tree==null){
            return last;
        }
        if(last ==null){
            last = tree;
        }else{
            last.right = tree;
            last.left = null;
            last = tree;
        }
        TreeNode leftNode = tree.left;
        TreeNode rightNode = tree.right;
        leftNode = preOrder(leftNode,last);
        rightNode = preOrder(rightNode,leftNode);

        return rightNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
