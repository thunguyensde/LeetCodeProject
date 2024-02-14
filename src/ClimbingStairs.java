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
    - dynamic programing:
        + d[n] = 0
        + d[i] = d[i - 1] + d[i - 2]

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

    public List<List<Integer>> climbingStairsBacktrackingTopDown(int n) {
        List<List<Integer>> steps = new LinkedList<>();
        climbingStairsTopDownHelper(0, n, new LinkedList<>(), steps);
        return steps;
    }

    private void climbingStairsTopDownHelper(int stair, int n, LinkedList<Integer> currentStep, List<List<Integer>> steps) {
        if (stair == n) {
            steps.add(new LinkedList<>(currentStep));
            return;
        }
        if (stair > n) {
            return;
        }
        currentStep.add(1);
        climbingStairsTopDownHelper(stair + 1, n, currentStep, steps);
        currentStep.removeLast();

        currentStep.add(2);
        climbingStairsTopDownHelper(stair + 2, n, currentStep, steps);
        currentStep.removeLast();
    }

    public List<List<Integer>> climbingStairsBacktrackingBottomUp(int n) {
        List<List<Integer>> steps = new LinkedList<>();
        climbingStairsBacktrackingBottomUpHelper(n, new LinkedList<>(), steps);
        return steps;
    }

    private void climbingStairsBacktrackingBottomUpHelper(int n, LinkedList<Integer> currentStep, List<List<Integer>> steps) {
        if (n == 0) {
            steps.add(new LinkedList<>(currentStep));
            return;
        }
        if (n < 0) {
            return;
        }
        currentStep.addFirst(1);
        climbingStairsBacktrackingBottomUpHelper(n - 1, currentStep, steps);
        currentStep.removeFirst();

        currentStep.addFirst(2);
        climbingStairsBacktrackingBottomUpHelper(n - 2, currentStep, steps);
        currentStep.removeFirst();
    }

    public int climbingStairsTopDown(int n) {
        AtomicInteger count = new AtomicInteger();
        climbingStairsTopDownHelper(0, n, count);
        return count.get();
    }

    private void climbingStairsTopDownHelper(int stair, int n, AtomicInteger count) {
        if (stair == n) {
            count.set(count.get() + 1);
            return;
        }
        if (stair > n) {
            return;
        }
        climbingStairsTopDownHelper(stair + 1, n, count);
        climbingStairsTopDownHelper(stair + 2, n, count);
    }

    public int climbingStairsTopDown_2(int n) {
        return climbingStairsTopDownHelper_2(0, n);
    }

    private int climbingStairsTopDownHelper_2(int stair, int n) {
        if (stair == n) {
            return 1;
        }
        if (stair > n) {
            return 0;
        }
        return climbingStairsTopDownHelper_2(stair + 1, n) +
                climbingStairsTopDownHelper_2(stair + 2, n);
    }

    public int climbingStairsBottomUp(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbingStairsBottomUp(n - 1) + climbingStairsBottomUp(n - 2);
    }

    public int climbingStairsBottomUpWithMemoization(int n) {
        return climbingStairsBottomUpWithMemoizationHelper(n, new int[n + 1]);
    }

    public int climbingStairsBottomUpWithMemoizationHelper(int n, int[] mem) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (mem[n] == 0) {
            mem[n] = climbingStairsBottomUpWithMemoizationHelper(n - 1, mem) +
                    climbingStairsBottomUpWithMemoizationHelper(n - 2, mem);
        }
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println(
                new ClimbingStairs().climbingStairsBottomUpWithMemoization(3)
        );
    }
}
