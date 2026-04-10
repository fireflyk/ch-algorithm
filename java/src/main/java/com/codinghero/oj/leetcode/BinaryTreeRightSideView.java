package com.codinghero.oj.leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> currentNodes = new LinkedList<>();
        List<Integer> results = new LinkedList<>();

        if (root != null) {
            currentNodes.add(root);
        }
        while (!currentNodes.isEmpty()) {
            results.add(currentNodes.peekLast().val);
            LinkedList<TreeNode> nextNodes = new LinkedList<>();
            for (TreeNode treeNode : currentNodes) {
                if (treeNode.left != null) {
                    nextNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextNodes.add(treeNode.right);
                }
            }
            currentNodes = nextNodes;
        }
        return results;
    }
}
