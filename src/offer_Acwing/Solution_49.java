package offer_Acwing;


class Solution_49 {
    public TreeNode convert(TreeNode root) {
        return getFirstNode(root,null);
    }

    public TreeNode getFirstNode(TreeNode root,TreeNode firstNode){
        if(root ==null){
            return firstNode;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        TreeNode rightFirstNode = getFirstNode(right,firstNode);

        if(rightFirstNode == null){
            rightFirstNode = root;
        }else{
            rightFirstNode.left = root;
            root.right = rightFirstNode;
            rightFirstNode = root;
        }

        TreeNode leftFirstNode = getFirstNode(left,rightFirstNode);

        return leftFirstNode;
    }
}