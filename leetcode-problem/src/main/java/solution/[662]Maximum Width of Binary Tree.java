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

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
class Solution_662 {
    class Pair{
        long minX;
        long maxX;
        public Pair(long minX, long maxX){
            this.minX = minX;
            this.maxX = maxX;
        }
        public String toString() {
            return this.minX + "\t" + this.maxX;
        }
    }
    Map<Long,Pair> levelNumMap = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        dfsTree(root,0,0);

        for(Pair pair: levelNumMap.values()){
            System.out.println(pair);
        }
        Pair pair = Collections.max(levelNumMap.values(), new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (int)(o1.maxX-o1.minX -(o2.maxX-o2.minX));
            }
        });
        return (int)(pair.maxX-pair.minX +1);
    }

    public void dfsTree(TreeNode root, long yLevel,long xLevel ){
        if(root == null){
            return;
        }
        Pair pair =  levelNumMap.get(yLevel);
        if(pair == null){
            pair = new Pair(xLevel,xLevel);
            levelNumMap.put(yLevel,pair);
        }else{
            if(xLevel< pair.minX){
                pair.minX = xLevel;
            }
            if(xLevel > pair.maxX){
                pair.maxX = xLevel;
            }
        }

        dfsTree(root.left,yLevel+1,2*xLevel);
        dfsTree(root.right,yLevel+1,2*xLevel+1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
