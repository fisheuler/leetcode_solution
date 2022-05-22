package solution;//Given the root of a binary tree, return the sum of values of its deepest leave
//s.
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//Output: 15
// 
//
// Example 2: 
//
// 
//Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//Output: 19
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// 1 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 2520 👎 78


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
class Solution_1302 {

    int currentMaxLevel=-1;
    int currentSum=0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return -1;
        }
        dfsTree(root,0);
        return currentSum;

    }

    public void dfsTree(TreeNode root,int level){
        if(root == null){
            return ;
        }

        if(level>currentMaxLevel){
            currentMaxLevel = level;
            currentSum +=root.val;
        }else if (level == currentMaxLevel){
            currentSum +=root.val;
        }

        dfsTree(root.left,level+1);
        dfsTree(root.right,level+1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
