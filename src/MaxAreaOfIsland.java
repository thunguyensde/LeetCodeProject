import java.util.HashSet;
import java.util.Set;

public class MaxAreaOfIsland {
    /*
    695.

    requirement:
    You are given an m x n binary matrix grid.
    An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
    You may assume all four edges of the grid are surrounded by water.

    The area of an island is the number of cells with a value 1 in the island.
    Return the maximum area of an island in grid. If there is no island, return 0.

    test case:
    0 1 0
    1 0 0
    1 0 0 --> 2

    solution:
    - depth first search
    - visited check mechanism
        + set/boolean 2-d array
        + modify input

    dry run:

    complexity:
    - time: O(m*n)
    - space: O(m*n)
    */

    public int getMaximumIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxIsland = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxIsland = Math.max(maxIsland, getMaximumIslandHelper(grid, i, j, visited));
            }
        }
        return maxIsland;
    }

    private int getMaximumIslandHelper(int[][] grid, int row, int col, Set<String> visited) {
        if (row < 0 || row >= grid.length) {
            return 0;
        }
        if (col < 0 || col >= grid[0].length) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 0;
        }
        if (visited.contains(row + "-" + col)) {
            return 0;
        }
        visited.add(row + "-" + col);
        return getMaximumIslandHelper(grid, row + 1, col, visited) +
                getMaximumIslandHelper(grid, row - 1, col, visited) +
                getMaximumIslandHelper(grid, row, col + 1, visited) +
                getMaximumIslandHelper(grid, row, col - 1, visited) + 1;
    }
}
