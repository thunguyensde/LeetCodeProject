public class WordSearch {
    /*
    79.

    */

    private int[][] neighbors = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existHelper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        board[row][col] = '#';
        for (int[] nb : neighbors) {
            int r = row + nb[0];
            int c = col + nb[1];
            if (existHelper(board, word, r, c, index + 1)) {
                return true;
            }
        }
        board[row][col] = word.charAt(index);
        return false;
    }
}
