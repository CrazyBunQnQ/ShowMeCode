package com.crazybunqnq.common;

/**
 * @version 2017/6/16.
 * @auther CrazyBunQnQ
 */
public class BinaryTreeNode<T> {
    public T val;
    public com.crazybunqnq.common.BinaryTreeNode left;
    public com.crazybunqnq.common.BinaryTreeNode right;

    BinaryTreeNode(T x) {
        val = x;
    }
}
