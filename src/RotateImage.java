public class RotateImage {
    /*
    48.

    */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l = n - 1;
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[l - j][i];
                matrix[l - j][i] = matrix[l - i][l - j];
                matrix[l - i][l - j] = matrix[j][l - i];
                matrix[j][l - i] = temp;
            }

            // temp = [0][0]
            // [0][0] = [3][0]
            // [3][0] = [3][3]
            // [3][3] = [0][3]
            // [0][3] = temp;

            // temp = [0][1]
            // [0][1] = [2][0]
            // [2][0] = [3][2]
            // [3][2] = [1][3]
            // [1][3] = temp

            // temp = [0][2]
            // [0][2] = [1][0]
            // [1][0] = [3][1]
            // [3][1] = [2][3]
            // [2][3] = temp

            // temp = [1][1]
            // [1][1] = [2][1]
            // [2][1] = [2][2]
            // [2][2] = [1][2]
            // [1][2] = temp
        }
    }
}
