//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode serializes
// a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
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
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics String Tree Depth-First Search Breadth-First Search Design Bin
//ary Tree 
// 👍 4849 👎 215


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.


    /*

    https://stackoverflow.com/questions/23754060/how-to-construct-a-binary-tree-using-a-level-order-traversal-sequence

        rootvalue,leftsize,rightSize,leftTreeString,rightTreeString
     */

    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(root.val);
        String leftTree = serialize(root.left);
        String rightTree = serialize(root.right);
        sb.append(","+leftTree.size());
        sb.append(","+rightTree.size());
        sb.append(","+leftTree);
        sb.sppend(","+rightTree);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        String[] array = data.split(",",4);
        TreeNode node = new TreeNode(Integer.valueOf(array[0]));
        int leftSize = Integer.valueOf(array[1]);
        int rightSize = Integer.valueOf(array[2]);
        String leftData = array[4].subString(0,leftSize-1);
        node.left = deserialize(leftData);
        node.right = deserialize(array[4].subString(leftSize));
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
