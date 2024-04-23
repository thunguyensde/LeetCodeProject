public class LongestPalindromicSubsequence {
    /*
    516.

    */

    public int longestPalindromeSubseq(String s) {
        char[] str = s.toCharArray();

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i == n - 1) break;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = Math.max(
                        dp[i + 1][j - 1] + (str[i] == str[j] ? 2 : 0),
                        Math.max(
                                dp[i][j - 1],
                                dp[i + 1][j]
                        )
                );
            }
        }

        return dp[0][n - 1];
    }
}
