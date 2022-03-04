//Given two binary search trees root1 and root2. 
//
// Return a list containing all the integers from both trees sorted in ascending
// order. 
//
// 
// Example 1: 
//
// 
//Input: root1 = [2,1,4], root2 = [1,0,3]
//Output: [0,1,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
//Output: [-10,0,0,1,2,5,7,10]
// 
//
// Example 3: 
//
// 
//Input: root1 = [], root2 = [5,1,7,0,2]
//Output: [0,1,2,5,7]
// 
//
// Example 4: 
//
// 
//Input: root1 = [0,-10,10], root2 = []
//Output: [-10,0,10]
// 
//
// Example 5: 
//
// 
//Input: root1 = [1,null,8], root2 = [8,1]
//Output: [1,1,8,8]
// 
//
// 
// Constraints: 
//
// 
// Each tree has at most 5000 nodes. 
// Each node's value is between [-10^5, 10^5]. 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Sorting Binary Tree
// 
// 👍 1156 👎 42


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> arrayList1 = new ArrayList<>();
        List<Integer> arrayList2 = new ArrayList<>();

        tranverseTree(root1,arrayList1);
        tranverseTree(root2,arrayList2);

        // merge and sort list;
        arrayList1.addAll(arrayList2);
        Collections.sort(arrayList1);
        return arrayList1;
    }

    public void tranverseTree(TreeNode node ,List<Integer> list){
        if(node == null){
            return;
        }
        tranverseTree(node.left,list);
        list.add(node.val);
        tranverseTree(node.right,list);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
