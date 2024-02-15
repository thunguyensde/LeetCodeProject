import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClimbingStairs {
    /*
    70.

    requirement:
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    test case:
    0 1 2 3 --> 1 + 1 + 1 = 3 ways

    solutions:
    - backtracking
        + backtracking with specific combinations
        + backtracking top down
        + backtracking bottom up
        + backtracking with memoization
    - dynamic programing
        + top down:
            + dp[i]: number of ways to climb from 0 -> stair ith
            + dp[0] = 1
            + dp[1] = 1
            + dp[i] = dp[i - 1] + dp[i - 2]
        + bottom up:
            + dp[i]: number of ways to climb from stair ith -> stair nth
            + dp[n] = 1
            + dp[n - 1] = 1
            + dp[i] = dp[i + 1] + dp[i + 2]

    dry run:

    complexity:
    - time: O(n)
    - space: O(1)
    */

    public int climbingStairs(int n) {
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }

    public List<List<Integer>> backtrackingTopDown(int n) {
        List<List<Integer>> steps = new LinkedList<>();
        backtrackingTopDownHelper(0, n, new LinkedList<>(), steps);
        return steps;
    }

    private void backtrackingTopDownHelper(int stair, int n, LinkedList<Integer> currentStep, List<List<Integer>> steps) {
        if (stair == n) {
            steps.add(new LinkedList<>(currentStep));
            return;
        }
        if (stair > n) {
            return;
        }
        currentStep.add(1);
        backtrackingTopDownHelper(stair + 1, n, currentStep, steps);
        currentStep.removeLast();

        currentStep.add(2);
        backtrackingTopDownHelper(stair + 2, n, currentStep, steps);
        currentStep.removeLast();
    }

    public List<List<Integer>> backtrackingBottomUp(int n) {
        List<List<Integer>> steps = new LinkedList<>();
        backtrackingBottomUpHelper(n, new LinkedList<>(), steps);
        return steps;
    }

    private void backtrackingBottomUpHelper(int n, LinkedList<Integer> currentStep, List<List<Integer>> steps) {
        if (n == 0) {
            steps.add(new LinkedList<>(currentStep));
            return;
        }
        if (n < 0) {
            return;
        }
        currentStep.addFirst(1);
        backtrackingBottomUpHelper(n - 1, currentStep, steps);
        currentStep.removeFirst();

        currentStep.addFirst(2);
        backtrackingBottomUpHelper(n - 2, currentStep, steps);
        currentStep.removeFirst();
    }

    public int topDown(int n) {
        AtomicInteger count = new AtomicInteger();
        topDownHelper(0, n, count);
        return count.get();
    }

    private void topDownHelper(int stair, int n, AtomicInteger count) {
        if (stair == n) {
            count.set(count.get() + 1);
            return;
        }
        if (stair > n) {
            return;
        }
        topDownHelper(stair + 1, n, count);
        topDownHelper(stair + 2, n, count);
    }

    public int topDown_2(int n) {
        return topDownHelper_2(0, n);
    }

    private int topDownHelper_2(int stair, int n) {
        if (stair == n) {
            return 1;
        }
        if (stair > n) {
            return 0;
        }
        return topDownHelper_2(stair + 1, n) +
                topDownHelper_2(stair + 2, n);
    }

    public int bottomUp(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return bottomUp(n - 1) + bottomUp(n - 2);
    }

    public int bottomUpWithMemoization(int n) {
        return bottomUpWithMemoizationHelper(n, new int[n + 1]);
    }

    public int bottomUpWithMemoizationHelper(int n, int[] mem) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (mem[n] == 0) {
            mem[n] = bottomUpWithMemoizationHelper(n - 1, mem) +
                    bottomUpWithMemoizationHelper(n - 2, mem);
        }
        return mem[n];
    }

    public int dynamicProgrammingTopDown(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int dynamicProgrammingBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(
                new ClimbingStairs().dynamicProgrammingBottomUp(3)
        );
    }
}
