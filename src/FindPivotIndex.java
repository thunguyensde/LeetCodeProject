public class FindPivotIndex {
    /*
    724.

    requirement:
    Given an array of integers nums, calculate the pivot index of this array.
    The pivot index is the index where the sum of all the numbers strictly to the left of the index
    is equal to the sum of all the numbers strictly to the index's right.

    If the index is on the left edge of the array,
    then the left sum is 0 because there are no elements to the left.
    This also applies to the right edge of the array.

    Return the leftmost pivot index. If no such index exists, return -1.

    test case:
    0 1 2 3 4 5 6
    1 2 3 0 3 2 1

    solution:
    prefix sum
    0 1 2 3 4 5 6  7
    0 1 3 6 6 9 11 12

    sum[0..i - 1] = prefixSum[i]
    */

    public int findPivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == prefixSum[n] - prefixSum[i] - nums[i]) {
                return i;
            }
        }

        return -1;
    }
}
