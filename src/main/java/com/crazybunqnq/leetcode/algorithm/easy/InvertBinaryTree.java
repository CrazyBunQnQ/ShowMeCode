package com.crazybunqnq.leetcode.algorithm.easy;

import com.crazybunqnq.common.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * to
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * Created by CrazyBun on 2016/7/7.
 */
public class InvertBinaryTree {
    /**
     * 比较快
     *
     * @param root
     *
     * @return
     */
    public static BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root == null) {
            return root;
        }

        BinaryTreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }

    /**
     * iteratively, using Queue
     *
     * @param root
     *
     * @return
     */
    public static BinaryTreeNode invertTree2(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                BinaryTreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
        }
        return root;
    }
}
