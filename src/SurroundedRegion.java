public class SurroundedRegion {
    /*
    130.

    requirement:
    Given an m x n matrix board containing 'X' and 'O',
    capture all regions that are 4-directionally surrounded by 'X'.
    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    test case:
    X X X
    X O O
    X X X
    -->
    X X X
    X O O
    X X X


    X X X X
    X O X O
    X O X X
    X X X X
    -->
    X X X X
    X X X O
    X X X X
    X X X X

    solution:
    - mark all region without X surrounding as Y

    dry run:

    complexity:
    - time: O(m * n)
    - space: O(m * n)
    */

    public void captureRegion(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int col = 0; col < n; col++) {
            markCell(board, 0, col, 'Y');
            markCell(board, m - 1, col, 'Y');
        }

        for (int row = 0; row < m; row++) {
            markCell(board, row, 0, 'Y');
            markCell(board, row, n - 1, 'Y');
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markCell(char[][] board, int row, int col, char marker) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col] == 'X' || board[row][col] == 'Y') {
            return;
        }
        board[row][col] = marker;
        markCell(board, row + 1, col, marker);
        markCell(board, row - 1, col, marker);
        markCell(board, row, col + 1, marker);
        markCell(board, row, col - 1, marker);
    }
}
