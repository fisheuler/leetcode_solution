package solution;//Serialization is the process of converting a data structure or object into a s
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Codec {

    // Encodes a tree to a single string.

    /*
        (rootvalue,(leftTreeString),(rightTreeString))
     */

    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<String> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()>0){
            TreeNode item = queue.poll();
            if(item ==null){
                list.add("#");
            }else{
                list.add(String.valueOf(item.val));
                queue.add(item.left);
                queue.add(item.right);
            }
        }
        return String.join(",",list);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        String[] array = data.split(",");

        int count = 0;
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        TreeNode cur = null;

        for(int i=1;i<array.length;i++){
            TreeNode node =null;
            if(!array[i].equals("#") ){
                node= new TreeNode(Integer.valueOf(array[i]));
                queue.add(node);
            }
            if(count == 0){
                cur = queue.poll();
            }
            if(count == 0){
                count++;
                cur.left = node;
            }else{
                count = 0 ;
                cur.right = node;
            }
        }

        return root;
    }

    public static void main(String[] args){
        String value ="#";
        if(value !="#"){
            System.out.println("value="+ value);
        }
        String encode= "1,2,3,#,#,4,5";

        TreeNode decode = deserialize(encode);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
