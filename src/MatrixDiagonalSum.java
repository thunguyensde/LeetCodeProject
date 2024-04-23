public class MatrixDiagonalSum {
    /*
    1572.

    */
    public int diagonalSum(int[][] mat) {
        // 2,0 -> 1,1 -> 0,2
        int n = mat.length;
        int diaSum = 0;
        for (int i = 0; i < n; i++) {
            diaSum += mat[i][i];
            diaSum += mat[i][n - i - 1];
        }
        return n % 2 == 0 ? diaSum : diaSum - mat[n / 2][n / 2];
    }
}
