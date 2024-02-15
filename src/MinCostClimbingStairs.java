public class MinCostClimbingStairs {
    /*
    746.

    requirement:
    You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
    Once you pay the cost, you can either climb one or two steps.

    You can either start from the step with index 0, or the step with index 1.
    Return the minimum cost to reach the top of the floor.

    test case:
    1 2 3 --> 2
    0 0 1

    solution:
    - top down
    - bottom up
    - memoization
    - dynamic programming
        + dp[i]: minimum cost to climb from 0 -> ith, say ith is the top
        + dp[0] = 0
        + dp[1] = 0
        + dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        + dp[n] = ?
    */
    public int dynamicProgramming(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return Math.min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2]);
    }
}
