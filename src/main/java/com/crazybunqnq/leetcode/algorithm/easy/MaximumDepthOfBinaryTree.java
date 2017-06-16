package com.crazybunqnq.leetcode.algorithm.easy;

import com.crazybunqnq.common.BinaryTreeNode;

import java.util.*;

/**
 * Given a binary tree, find its maximum depth. The maximum depth is the number
 * of nodes along the longest path from the root node down to the farthest leaf
 * node.
 * <p>
 * Definition for a binary tree node. public class BinaryTreeNode { int val;
 * BinaryTreeNode left; BinaryTreeNode right; BinaryTreeNode(int x) { val = x; }
 * }
 * <p>
 * Created by CrazyBun on 2016/7/7.
 */
public class MaximumDepthOfBinaryTree {
    /**
     * 超慢
     *
     * @param root
     *
     * @return
     */
    public static int maxDepth1(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<BinaryTreeNode, Integer> depthMap = new HashMap<BinaryTreeNode, Integer>();
        depthMap.put(root, 1);
        int maxDepth = 1;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            int depth = depthMap.get(root);
            maxDepth = Math.max(maxDepth, depthMap.get(root));
            if (root.right != null) {
                depthMap.put(root.right, depth + 1);
                stack.push(root.right);
            }
            if (root.left != null) {
                depthMap.put(root.left, depth + 1);
                stack.push(root.left);
            }
            depthMap.remove(root);
        }
        return maxDepth;
    }

    /**
     * 慢
     *
     * @param root
     *
     * @return
     */
    public static int maxDepth2(BinaryTreeNode root) {
        if (root == null)
            return 0;

        Deque<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();

        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                BinaryTreeNode cur = stack.pop();
                if (cur.left != null)
                    stack.addLast(cur.left);
                if (cur.right != null)
                    stack.addLast(cur.right);
            }
            count++;

        }
        return count;
    }

    /**
     * 同下
     *
     * @param root
     *
     * @return
     */
    public static int maxDepth3(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    /**
     * 略快
     *
     * @param root
     *
     * @return
     */
    public static int maxDepth(BinaryTreeNode root) {
        // if(root==null){
        // return 0;
        // }
        // return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
