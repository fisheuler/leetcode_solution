package solution.adt;/*
 * Copyright (c) 2021
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 2021/8/5
 */
public class Node {
    int val;
    public Node left;
    public Node right;
    public Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}