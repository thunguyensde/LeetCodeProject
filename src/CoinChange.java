public class CoinChange {
    /*
    322.

    */

    public int coinChange(int[] coins, int amount) {
        // [1,2,5] & 6
        // 1,1,1,1,1,1
        // 1,1,1,1,2
        // 1,1,2,2
        // 2,2,2
        // 1,5 --> return 2
        // -----
        // [2,5] & 6
        // 2,2,2
        // 1 --> dp[1]=-1
        // dp[i]: minimum number of coins to make up for amount=i
        // dp[0]: 0
        // dp[6]: final result
        // dp[i] = min(dp[i - coins[i]], dp[i - coins[i + 1]], ...) + 1

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minNumOfCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minNumOfCoins = Math.min(minNumOfCoins, dp[i - coin]);
                }
            }
            dp[i] = minNumOfCoins == Integer.MAX_VALUE ? minNumOfCoins : minNumOfCoins + 1;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
