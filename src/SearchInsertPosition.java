public class SearchInsertPosition {
    /*
    35.

    requirement:
    Given a sorted array of distinct integers and a target value,
    return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.

    test case:
    [3], target = 2 -->
    [3], target = 5 -->

    solution:
    - binary search

    complexity:
    - time: O(logn)
    - space: O(1)
    */

    public int getInsertIndex(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
