import common.TreeNode;

import java.util.concurrent.atomic.AtomicBoolean;

public class BalancedBinaryTree {
    /*
    110.

    requirement:
    Given a binary tree, determine if it is height-balanced.
    Height-balanced tree mean, height of left tree and right tree of any nodes don't differ greater than 1

    test case:
    5 --> true

    solution:
    - depth first search
    - get height of left sub-tree, height of right sub-tree
    - return max(height of left sub-tree, height of right sub-tree) + 1
    - approaches:
        + AtomicBoolean
        + Global variable

    dry run:

    complexity:
    - time: O(n)
    - space: O(n)
    */
    public boolean isHeightBalancedBinaryTree(TreeNode root) {
        AtomicBoolean isHeightBalanced = new AtomicBoolean(true);
        isHeightBalancedBinaryTreeHelper(root, isHeightBalanced);
        return isHeightBalanced.get();
    }

    private int isHeightBalancedBinaryTreeHelper(TreeNode root, AtomicBoolean isHeightBalanced) {
        if (root == null) {
            return 0;
        }
        if (!isHeightBalanced.get()) {
            return 0;
        }
        int heightOfLeftSubTree = isHeightBalancedBinaryTreeHelper(root.left, isHeightBalanced);
        int heightOfRightSubTree = isHeightBalancedBinaryTreeHelper(root.right, isHeightBalanced);
        if (Math.abs(heightOfRightSubTree - heightOfLeftSubTree) > 1) {
            isHeightBalanced.set(false);
        }
        return Math.max(heightOfLeftSubTree, heightOfRightSubTree) + 1;
    }
}
