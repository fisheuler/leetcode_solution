package solution;//Given the root of a binary search tree and the lowest and highest boundaries a
//s low and high, trim the tree so that all its elements lies in [low, high]. Trim
//ming the tree should not change the relative structure of the elements that will
// remain in the tree (i.e., any node's descendant should remain a descendant). It
// can be proven that there is a unique answer. 
//
// Return the root of the trimmed binary search tree. Note that the root may cha
//nge depending on the given bounds. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,0,2], low = 1, high = 2
//Output: [1,null,2]
// 
//
// Example 2: 
//
// 
//Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//Output: [3,2,null,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree in the range [1, 104]. 
// 0 <= Node.val <= 104 
// The value of each node in the tree is unique. 
// root is guaranteed to be a valid binary search tree. 
// 0 <= low <= high <= 104 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 3716 👎 223


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
class Solution_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root ==null){
            return root;
        }
        TreeNode left = trimBST(root.left,low,high);
        TreeNode right = trimBST(root.right,low,high);

        if(root.val >high || root.val <low){
            // we should
            if(left==null){
                return right;
            }else if (right==null){
                return left;
            }else{
                TreeNode node = right;
                while(node.left!=null){
                    node=node.left;
                }
                node.left=left;
                return right;
            }

        }else{
            root.left = left;
            root.right = right;
            return root;
        }
    }
















}
//leetcode submit region end(Prohibit modification and deletion)
