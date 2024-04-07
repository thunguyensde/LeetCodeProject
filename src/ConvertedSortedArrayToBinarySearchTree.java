import common.TreeNode;

public class ConvertedSortedArrayToBinarySearchTree {
    /*
    108.

    requirement:
    Given an integer array nums where the elements are sorted in ascending order,
    convert it to a height-balanced binary search tree.

    test case:
    [-10,-3,0,5,9]

    */

    public TreeNode convertArrayToBst(int[] nums) {
        return convertArrayToBstHelper(nums, 0, nums.length - 1);
    }

    private TreeNode convertArrayToBstHelper(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convertArrayToBstHelper(nums, left, mid - 1);
        node.right = convertArrayToBstHelper(nums, mid + 1, right);
        return node;
    }
}
