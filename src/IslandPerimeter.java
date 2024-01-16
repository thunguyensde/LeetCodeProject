public class IslandPerimeter {
    /*
    463.

    requirement:
    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
    Grid cells are connected horizontally/vertically (not diagonally).
    The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
    One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
    Determine the perimeter of the island.

    test case:
    0 0 0 0 0
    0 1 1 1 0
    0 1 1 1 0
    0 1 1 1 0
    0 0 0 0 0
    --> 12

    1
    --> 4

    1 1 0
    0 1 1
    --> 10

    solution:
    - depth first search
        - Set<String> visited cell
        - Modify grid, then roll back
    - if cell = 1, check 4 neighboring cell
        - neighboring cell = 0, perimeter++

    dry run:

    complexity:
    - time: O(m * n)
    - space: O(m * n)
    */

    public int calculateIslandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int perimeter = calculateIslandPerimeterHelper(grid, 0, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 9) {
                    grid[i][j] = 1;
                } else if (grid[i][j] == 3) {
                    grid[i][j] = 0;
                }
            }
        }

        return perimeter;
    }

    private int calculateIslandPerimeterHelper(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 9 || grid[row][col] == 3) {
            return 0;
        }

        int facingWaterSides = 0;
        if (grid[row][col] == 0) {
            grid[row][col] = 3;
        } else {
            if (row - 1 < 0 || grid[row - 1][col] == 0 || grid[row - 1][col] == 3) facingWaterSides++;
            if (row + 1 >= grid.length || grid[row + 1][col] == 0 || grid[row + 1][col] == 3) facingWaterSides++;
            if (col - 1 < 0 || grid[row][col - 1] == 0 || grid[row][col - 1] == 3) facingWaterSides++;
            if (col + 1 >= grid[0].length || grid[row][col + 1] == 0 || grid[row][col + 1] == 3) facingWaterSides++;
            grid[row][col] = 9;
        }

        return facingWaterSides
                + calculateIslandPerimeterHelper(grid, row + 1, col)
                + calculateIslandPerimeterHelper(grid, row - 1, col)
                + calculateIslandPerimeterHelper(grid, row, col + 1)
                + calculateIslandPerimeterHelper(grid, row, col - 1);
    }

    public int simpleCalculateIslandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int perimeter = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int facingWaterSides = 0;
                if (grid[row][col] == 1) {
                    if (row - 1 < 0 || grid[row - 1][col] == 0 || grid[row - 1][col] == 3) facingWaterSides++;
                    if (row + 1 >= grid.length || grid[row + 1][col] == 0 || grid[row + 1][col] == 3) facingWaterSides++;
                    if (col - 1 < 0 || grid[row][col - 1] == 0 || grid[row][col - 1] == 3) facingWaterSides++;
                    if (col + 1 >= grid[0].length || grid[row][col + 1] == 0 || grid[row][col + 1] == 3) facingWaterSides++;
                }
                perimeter += facingWaterSides;
            }
        }

        return perimeter;
    }
}
