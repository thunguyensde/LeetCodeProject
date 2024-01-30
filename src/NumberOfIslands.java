public class NumberOfIslands {
    /*
    200.

    requirement:
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
    return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    test case:
    1 0 1
    0 1 0
    1 1 1
    --> 3

    solution:
    - depth first search
    - mark visited?
        - modify input --> rollback
        - hashset

    dry run:

    complexity:
    - time: O(m*n)
    - space: O(m*n)
    */

    public int countNumberOfIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numberOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    countNumberOfIslandsHelper(grid, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 'X') {
                    grid[i][j] = '1';
                }
            }
        }
        return numberOfIslands;
    }

    private void countNumberOfIslandsHelper(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) return;
        if (col < 0 || col >= grid[0].length) return;
        if (grid[row][col] == '0') return;
        if (grid[row][col] == 'X') return;
        grid[row][col] = 'X';
        countNumberOfIslandsHelper(grid, row + 1, col);
        countNumberOfIslandsHelper(grid, row - 1, col);
        countNumberOfIslandsHelper(grid, row, col + 1);
        countNumberOfIslandsHelper(grid, row, col - 1);
    }
}
