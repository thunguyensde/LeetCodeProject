import common.TreeNode;

public class InvertBinaryTree {
    /*
    226.

    requirement:
    Given the root of a binary tree, invert the tree, and return its root.

    test case:
            1
        2       3
    4       5

            1
        3       2
            5       4

    solution:
    - recursive

    complexity:
    - time: O(n)
    - space: O(n)
    */

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
