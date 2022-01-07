//Given the root of a binary tree, find the maximum value v for which there exis
//t different nodes a and b where v = |a.val - b.val| and a is an ancestor of b. 
//
// A node a is an ancestor of b if either: any child of a is equal to b or any c
//hild of a is an ancestor of b. 
//
// 
// Example 1: 
//
// 
//Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
//Output: 7
//Explanation: We have various ancestor-node differences, some of which are give
//n below :
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//Among all possible differences, the maximum value of 7 is obtained by |8 - 1| 
//= 7. 
//
// Example 2: 
//
// 
//Input: root = [1,null,2,null,0,3]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 5000]. 
// 0 <= Node.val <= 105 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 1665 👎 48


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
    /*
        思路，没有思路，参照leetcode上题解
        https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/solution/

        递归遍历树，每个节点都计算一下max_diff,而max_diff计算需要维护max_value和min_value这两个值，
        主要计算逻辑分三个步骤：
        1 计算当前节点的max_diff，更新max_diff
        2 更新现在维护的max_value和min_value
        3 递归DFS计算max_diff
     */
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        return maxDiff(root,root.val,root.val);
    }

    public int maxDiff(TreeNode root,int currMax,int currMin){
        if(root==null){
            return 0;
        }
        currMax = Math.max(currMax,root.val);
        currMin = Math.min(currMin,root.val);

        int leftMaxDiff = maxDiff(root.left,currMax,currMin);
        int rightMaxDiff = maxDiff(root.right,currMax,currMin);
        int currRootMaxDiff = Math.abs(currMax-currMin);
        return Math.max(currRootMaxDiff,Math.max(leftMaxDiff,rightMaxDiff));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
