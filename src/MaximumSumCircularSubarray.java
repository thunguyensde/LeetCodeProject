public class MaximumSumCircularSubarray {
    /*
    918.

    requirement:
    Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
    A circular array means the end of the array connects to the beginning of the array.
    Formally, the next element of nums[i] is nums[(i + 1) % n] and
    the previous element of nums[i] is nums[(i - 1 + n) % n].

    A subarray may only include each element of the fixed buffer nums at most once.
    Formally, for a subarray nums[i], nums[i + 1], ..., nums[j],
    there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

    Input: nums = [5,-3,5]
    Output: 10
    Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

    test case:
    6 -7 10 3 -2 --> don't add 10
    6 -7 10 -20 9 --> add 10

    solution:
    - normal maximum subarray: O(n)
    - circular --> O(n^2)
    */

    public int maxCircularSubarray(int[] nums) {
        int currentMaxSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMinSum = 0;
        int minSum = Integer.MAX_VALUE;
        int total = 0;
        for (int num : nums) {
            currentMaxSum = Math.max(currentMaxSum + num, num);
            maxSum = Math.max(maxSum, currentMaxSum);

            currentMinSum = Math.min(currentMinSum + num, num);
            minSum = Math.min(minSum, currentMinSum);
            total += num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
