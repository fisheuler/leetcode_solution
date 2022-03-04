package solution;//Given the root of a binary tree, return the maximum width of the given tree.
//
// The maximum width of a tree is the maximum width among all levels. 
//
// The width of one level is defined as the length between the end-nodes (the le
//ftmost and rightmost non-null nodes), where the null nodes between the end-nodes
// are also counted into the length calculation. 
//
// It is guaranteed that the answer will in the range of 32-bit signed integer. 
//
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,2,5,3,null,9]
//Output: 4
//Explanation: The maximum width existing in the third level with the length 4 (
//5,3,null,9).
// 
//
// Example 2: 
//
// 
//Input: root = [1,3,null,5,3]
//Output: 2
//Explanation: The maximum width existing in the third level with the length 2 (
//5,3).
// 
//
// Example 3: 
//
// 
//Input: root = [1,3,2,5]
//Output: 2
//Explanation: The maximum width existing in the second level with the length 2 
//(3,2).
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3000]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 3547 👎 562


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
class Solution_622_Queue {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int maxWidth = 0;
        while(nodeQueue.size()>0){
            int size = nodeQueue.size();
            int first = -1, second = -1;

            for(int i=0;i<size;i++){
                TreeNode node = nodeQueue.poll();
                if(node!=null){
                    nodeQueue.add(node.left);
                    nodeQueue.add(node.right);
                    if(first == -1){
                        first = i;
                    }
                    second = i;
                }
            }

            int length = second - first +1;

            if(length>maxWidth){
                maxWidth = length;
            }
        }

        return maxWidth;

    }


    public static void main(String[] args){
        Solution_622_Queue solution = new Solution_622_Queue();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        TreeNode left_left = new TreeNode(5);
        TreeNode left_right = new TreeNode(3);

        TreeNode right_right = new TreeNode(9);

        left.left = left_left;
        left.right = left_right;

        right.left = null;
        right.right = right_right;


        System.out.println(solution.widthOfBinaryTree(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
