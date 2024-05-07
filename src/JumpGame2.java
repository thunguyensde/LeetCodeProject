import java.util.Arrays;

public class JumpGame2 {
    /*
    45.

    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
    Each element nums[i] represents the maximum length of a forward jump from index i.
    In other words, if you are at nums[i], you can jump to any nums[i + j] where:

    0 <= j <= nums[i] and
    i + j < n

    Return the minimum number of jumps to reach nums[n - 1].
    The test cases are generated such that you can reach nums[n - 1].


    Example 1:

    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:

    Input: nums = [2,3,0,1,4]
    Output: 2


    Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 1000
    It's guaranteed that you can reach nums[n - 1].
    */

    // Input: nums = [2,3,1,1,1,4]

    public int myJumpWithGreedy(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int curIdx = 0;
        int minStep = 0;
        while(curIdx < n - 1 && curIdx + nums[curIdx] < n - 1) {
            int steps = nums[curIdx];
            int maxReachableIdx = curIdx;
            int nextIdx = curIdx;
            for (int step = 1; step <= steps && curIdx + step < n; step++) {
                int reachableIdx = curIdx + step + nums[curIdx + step];
                if (reachableIdx >= maxReachableIdx) {
                    maxReachableIdx = reachableIdx;
                    nextIdx = curIdx + step;
                }
            }
            minStep++;
            curIdx = nextIdx;
        }
        return minStep + 1;
    }

    public int myJumpWithDynamicProgramming(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int numStep = nums[i];
            for (int step = 1; step <= numStep && i + step < n; step++) {
                dp[i] = Math.min(dp[i + step], dp[i]);
            }
            dp[i] += 1;
        }
        return dp[0];
    }

    // Based on BFS
    public int shortestGreedyJump(int[] nums) {
        int n = nums.length;
        int minStep = 0;
        int left = 0, right = 0;
        while (right < n - 1) {
            int farthestIdx = left;
            for (int idx = left; idx <= right; idx++) {
                farthestIdx = Math.max(idx + nums[idx], farthestIdx);
            }
            minStep++;
            left = right + 1;
            right = farthestIdx;
        }
        return minStep;
    }
}
