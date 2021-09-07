package solution;

import java.util.Comparator;
import java.util.PriorityQueue;

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
class Priority {

    public static void main(String[] args){
        PriorityQueue<Integer> p = new PriorityQueue(Comparator.reverseOrder());

        for(int i=0;i<10;i++){
            p.add(i);
        }

        while(p.size()>0){
            System.out.println(p.poll());
        }
    }

}