import java.util.Arrays;

public class CoinChange2 {
    /*
    518.

    */

    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return changeHelper(amount, coins, 0, dp);
    }

    private int changeHelper(int amount, int[] coins, int index, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (index == coins.length) {
            return 0;
        }
        if (dp[amount][index] == -1) {
            dp[amount][index] = changeHelper(amount - coins[index], coins, index, dp) +
                    changeHelper(amount, coins, index + 1, dp);
        }
        return dp[amount][index];
    }
}
