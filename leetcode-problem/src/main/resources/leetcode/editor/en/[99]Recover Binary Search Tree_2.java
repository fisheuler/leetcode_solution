//You are given the root of a binary search tree (BST), where exactly two nodes 
//of the tree were swapped by mistake. Recover the tree without changing its struc
//ture. 
//
// Follow up: A solution using O(n) space is pretty straight forward. Could you 
//devise a constant space solution? 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 mak
//es the BST valid.
// 
//
// Example 2: 
//
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 a
//nd 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 3010 👎 118


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
    //https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal


    TreeNode firstNode ;
    TreeNode secondNode;
    TreeNode preNode;

    public void recoverTree(TreeNode root) {
        tranverse(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }


    private void tranverse(TreeNode root){
        if(root == null){
            return;
        }
        tranverse(root.left);
        // root visist

        if(preNode == null){
            preNode = root;
        }else{
            if(preNode.val > root.val){
                if(firstNode == null){
                    firstNode = preNode;
                }else{
                    secondNode = root;
                }
            }
            preNode = root;
        }

        tranverse(root.right);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
