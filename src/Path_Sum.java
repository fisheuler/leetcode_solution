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
class Path_Sum {

    private static int totalCount = 0;

    public int pathSum(TreeNode root, int targetSum) {
        iterateTree(root,targetSum);
        return totalCount;
    }
    private static Map<Integer,Integer> iterateTree(TreeNode root,int targetSum){
        if(root == null){
            return new HashMap<>();
        }
        Map<Integer,Integer> leftMap = iterateTree(root.left,targetSum);
        Map<Integer,Integer> rightMap = iterateTree(root.right,targetSum);
        Map<Integer,Integer> nodeMap = new HashMap<>();
        nodeMap.put(0,0);
        HashMap<Integer,Integer> temp = new HashMap<>();
        sumMap(leftMap,temp,root,targetSum);
        sumMap(rightMap,temp,root,targetSum);
        sumMap(nodeMap,temp,root,targetSum);
        return temp;
    }
    private static void sumMap(Map<Integer,Integer> subtreeMap,Map<Integer,Integer> currentTreeMap,TreeNode root,int targetSum){
        for(Map.Entry<Integer,Integer> entry: subtreeMap.entrySet()){
            int sum = entry.getKey();
            int count = entry.getValue();
            int addSum = sum + root.val;
            if(addSum == targetSum){
                totalCount ++;
            }
            int addSumCount = currentTreeMap.getOrDefault(addSum,0);
            currentTreeMap.put(addSum,addSumCount+count);
        }
    }







}