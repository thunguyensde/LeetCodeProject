public class LongestCommonSubsequence {
    /*
    1143.

    */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEqual = text1.charAt(i) == text2.charAt(j);
                if (i == 0 && j == 0) {
                    dp[i][j] = isEqual ? 1 : 0;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = isEqual || dp[i][j - 1] == 1 ? 1 : 0;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = isEqual || dp[i - 1][j] == 1 ? 1 : 0;
                    continue;
                }
                dp[i][j] = isEqual ?
                        dp[i - 1][j - 1] + 1 :
                        Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
