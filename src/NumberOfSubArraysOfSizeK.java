public class NumberOfSubArraysOfSizeK {
    /*
    1343.

    requirement:
    Given an array of integers arr and two integers k and threshold,
    return the number of sub-arrays of size k and average greater than or equal to threshold.

    test case:
    1 2 3 4 5; k = 3; threshold = 1

    solution:
    sliding window

    complexity:
    time: O(n)
    space: O(1)
    */

    public int numberOfSubArraysSizeKAverageGreaterThanThreshold(int[] arr, int k, int threshold) {
        int n = arr.length;
        int numSubArray = 0;

        int thresholdSum = threshold * k;
        for (int i = 0; i < k; i++) {
            thresholdSum -= arr[i];
        }
        if (thresholdSum <= 0) {
            numSubArray++;
        }

        for (int i = 1; i <= n - k; i++) {
            thresholdSum += arr[i - 1];
            thresholdSum -= arr[i + k - 1];
            if (thresholdSum <= 0) {
                numSubArray++;
            }
        }

        return numSubArray;
    }
}
