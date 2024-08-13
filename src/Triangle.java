import java.util.List;

public class Triangle {
    /*
    120.

    */

    public int minimumTotal(List<List<Integer>> triangle) {
        // minimum path sum at row [i] col [j] = Math.min (minimum path sum at row [i - 1] col[j], minimum path sum at row [i - 1] col[j - 1]) + triangle[i][j]

        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int r = 1; r < n; r++) {
            for (int c = 0; c <= r; c++) {
                dp[r][c] = Math.min(dp[r - 1][c == r ? c - 1 : c], dp[r - 1][c == 0 ? 0 : c - 1]) + triangle.get(r).get(c);
            }
        }

        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][i]);
        }

        return minPathSum;
    }
}
