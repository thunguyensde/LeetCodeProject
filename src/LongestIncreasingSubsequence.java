import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    /*
    300.

    requirement:
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

    test case:
    10 2 4 11 5 --> 3

    at 11:
    10, 11
    2, 4, 11

    10 11 15 20
    number = 13

    1 2 100 200 3 4 5 6 1000
    1 2 100 200 300 400 600 700 800 3 4 5 6 1000
    1 2 100 200 300 400 600 700 800 3 4 5 6 7 8 9 10 11 12 13 1000
    solutions:
    - dynamic programming
        - dp[i]: length of the longest subsequence end with nums[i]
        - dp[i] = 1 + Math.max(dp[0...i-1]) where nums[0...i-1] < nums[i]
        - dp[0] = 1
        - the answer is Math.max(dp[0...n-1])
        - complexity: O(n^2)
    - extra array: 2,4,5 --> greedy
        - binary search the position of the number;
        - complexity: nlogn

    */
    public int longestIncreasingSubsequence(int[] nums) {
        List<Integer> increasingSubsequence = new ArrayList<>();
        for (int num : nums) {
            int position = findPosition(increasingSubsequence, num);
            if (position == increasingSubsequence.size()) {
                increasingSubsequence.add(num);
            } else {
                increasingSubsequence.set(position, num);
            }
        }
        return increasingSubsequence.size();
    }
    // 0 1 2 3 4 5
    // 3 5 5 5 5 7

    private int findPosition(List<Integer> subsequence, int number) {
        int left = 0;
        int right = subsequence.size() - 1;
        while (left <= right) {
            int mid = right + (left - right) / 2;
            /*
            TODO: remember the < here is important. If it was <=, then the algo is wrong.
             when [mid] is equal to number. if we increase left, we will end up with fx: 3 5 5 5 5 5
             otherwise, if we decrease right, we will end up with fx: 3 5
            */

            if (subsequence.get(mid) < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int longestIncreasingSubsequenceWithDynamicProgramming(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int longestSubsequence = 0;
        for (int i = 1; i < n; i++) {
            int longestPreviousSubsequence = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    longestPreviousSubsequence = Math.max(longestPreviousSubsequence, dp[j]);
                }
            }
            dp[i] = longestPreviousSubsequence + 1;
            longestSubsequence = Math.max(longestSubsequence, dp[i]);
        }
        return longestSubsequence;
    }
}
