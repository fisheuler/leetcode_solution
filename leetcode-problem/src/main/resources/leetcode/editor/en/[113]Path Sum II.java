//Given the root of a binary tree and an integer targetSum, return all root-to-l
//eaf paths where each path's sum equals targetSum. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], targetSum = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics Backtracking Tree Depth-First Search Binary Tree 
// 👍 3378 👎 92


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
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

    }

    public void pathRecursive(TreeNode root,int targetSum,List<String> path){
        if(root==null){
            return result;
        }
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                result.add(new ArrayList(path).add(root.val));
            }
            return;
        }

        if(root.left!=null){
            pathRecursive(root.left,targetSum-root.val,path.add(root.val));
            path.deleteByIndex(path.length()-1);
        }
        if(root.right!=null){
            pathRecursive(root.right,targetSum-root.val,path.add(root.val));
            path.deleteByIndex(path.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
