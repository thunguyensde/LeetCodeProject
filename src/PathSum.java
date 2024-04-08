import common.TreeNode;

public class PathSum {
    /*
    112.

    requirement:
    Given the root of a binary tree and an integer targetSum,
    return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
    A leaf is a node with no children.
    */

    public boolean pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return pathSum(root.left, targetSum - root.val) ||
                pathSum(root.right, targetSum - root.val);
    }
}
