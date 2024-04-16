public class MaximumSubarray {
    /*
    53

    requirement:
    Given an integer array nums, find the subarray with the largest sum, and return its sum.

    test case:
    0  1 2 3  4
    1 -2 3 4 -5 --> 7

    [0] + [1] + [2] + [3] - ([0] + [1])
    solution:
    - sum from nums[i] --> nums[j] (inclusive) = prefixSum[j] - prefixSum[i - 1] (i > 0)
    - sum from nums[i] --> nums[j] (inclusive) = prefixSum[j] (i == 0)

    ==> largest sum of subarray ending at nums[j] (inclusive) = min(0, prefixSum[0], ..., prefixSum[j - 1])

    dry run:

    complexity:
    - time: O(n)
    - space: O(1)
    */

    public int sumOfMaximumSubarray(int[] nums) {
        int minPrefixSum = 0;
        int curPrefixSum = 0;
        int largestSum = Integer.MIN_VALUE;
        for (int num : nums) {
            curPrefixSum += num;
            largestSum = Math.max(largestSum, curPrefixSum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, curPrefixSum);
        }
        return largestSum;
    }

    public int kadaneAlgorithm(int[] nums) {
        int n = nums.length;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
