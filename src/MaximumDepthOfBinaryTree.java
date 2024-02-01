import common.TreeNode;

public class MaximumDepthOfBinaryTree {
    /*
    104.

    requirement:
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    test case:

    solution:
    - depth first search
    - breadth first search

    dry run:

    complexity:
    - time: O(n)
    - space: O(n)
    */

    public int getDepthOfBinaryTree(TreeNode root){
        if (root == null) return 0;
        return Math.max(
                getDepthOfBinaryTree(root.left),
                getDepthOfBinaryTree(root.right)
        ) + 1;
    }
}
