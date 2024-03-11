import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    /*
    1984.

    requirement:
    You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student.
    You are also given an integer k.
    Pick the scores of any k students from the array so that the difference between
    the highest and the lowest of the k scores is minimized.
    Return the minimum possible difference.

    test case:
    9 7 8 4 5
    4 5 7 8 9
    k = 3
    --> 2 [9,7,8]

    solution:
    sorting
    */

    public int minimumScoreDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int lowest = 0;
        int highest = k - 1;
        int minimumDifference = nums[n - 1] - nums[0];
        while (highest < n) {
            minimumDifference = Math.min(minimumDifference, nums[highest] - nums[lowest]);
            lowest++;
            highest++;
        }
        return minimumDifference;
    }
}
