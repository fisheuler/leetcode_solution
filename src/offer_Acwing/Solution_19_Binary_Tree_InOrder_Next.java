/*
 * Copyright (c) 2021 koolearn.com
 * All rights reserved.
 *
 */
package offer_Acwing;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 2021/8/11
 */
public class Solution_19_Binary_Tree_InOrder_Next {
    public TreeNode inorderSuccessor(TreeNode p) {
        if(p==null){
            return null;
        }
        if(p.right!=null){
            TreeNode next = p.right;
            while(next.left!=null){
                next = next.left;
            }
            return next;
        }

        TreeNode parent = p.father;
        TreeNode child = p;
        while(parent !=null && parent.left!=child ){
            child = parent;
            parent = child.father;
        }

        return parent;
    }
}