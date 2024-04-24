import java.util.Arrays;

public class LastStoneWeight2 {
    /*
    1049.

    */

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += stones[i];
        }

        int[][] memo = new int[n][total];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return lastStoneWeightIIHelper(stones, 0, 0, total, memo);
    }

    private int lastStoneWeightIIHelper(int[] stones, int index, int sum, int total, int[][] memo) {
        if (index == stones.length) {
            return Math.abs(sum - (total - sum));
        }
        if (memo[index][sum] == -1) {
            memo[index][sum] = Math.min(
                    lastStoneWeightIIHelper(stones, index + 1, sum + stones[index], total, memo),
                    lastStoneWeightIIHelper(stones, index + 1, sum, total, memo)
            );
        }
        return memo[index][sum];
    }

}
