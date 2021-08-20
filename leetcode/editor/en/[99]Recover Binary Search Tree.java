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
    TreeNode wrong ;
    public void recoverTree(TreeNode root) {
        tranverse(root);
    }

    private void tranverse(TreeNode root){
        if(root ==null){
            return;
        }
        if(validTree(root.left,root.val,1) && validTree(root.right,root.val,2)){
            tranverse(root.left);
            tranverse(root.right);
        }else{
            int temp = root.val;
            root.val = wrong.val;
            wrong.val = temp;
        }
    }

    private boolean validTree(TreeNode root,int val,int relation){
        if(root==null){
            return true;
        }
        if(relation == 1){

            if(root.val > val){
                wrong = root;
                return false;
            }

            if(validTree(root.left,val,relation) && validTree(root.right,val,relation)){
                return true;
            }else{
                return false;
            }
        }else{
            if(root.val < val){
                wrong = root;
                return false;
            }
            if(validTree(root.left,val,relation) && validTree(root.right,val,relation)){
                return true;
            }else{
                return false;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
