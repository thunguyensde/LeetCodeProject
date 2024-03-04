public class CountSubIslands {
    /*
    1905.

    requirement:
    You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water)
    and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical).
    Any cells outside of the grid are considered water cells.

    An island in grid2 is considered a sub-island if there is an island in grid1
    that contains all the cells that make up this island in grid2.

    Return the number of islands in grid2 that are considered sub-islands.

    test case:
    1 1 0
    1 1 0
    0 0 0

    0 1 0
    0 1 0
    0 0 0 --> 1

    0 1 0
    0 1 -1
    0 0 0 --> 0

    solution
    - depth first search
    - find island cells in grid2, but not in grid1, mark them as -1
    - count all 1 island

    dry run

    complexity:
    - time: O(m * n)
    - space: O(m * n)
    */

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;;
        int n = grid1[0].length;

        boolean[][] notSubIslandGrid = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!notSubIslandGrid[i][j] && grid2[i][j] == 1 && grid1[i][j] == 0) {
                    countSubIslandHelper(grid2, notSubIslandGrid, i, j);
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        int countSubIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!notSubIslandGrid[i][j] && !visited[i][j] && grid2[i][j] == 1) {
                    countSubIsland++;
                    countSubIslandHelper(grid2, visited, i, j);
                }
            }
        }

        return countSubIsland;
    }

    private void countSubIslandHelper(int[][] grid2, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid2.length) {
            return;
        }
        if (col < 0 || col >= grid2[0].length) {
            return;
        }
        if (grid2[row][col] == 0) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        countSubIslandHelper(grid2, visited, row + 1, col);
        countSubIslandHelper(grid2, visited, row - 1, col);
        countSubIslandHelper(grid2, visited, row, col + 1);
        countSubIslandHelper(grid2, visited, row, col - 1);
    }

     public int countSubIslandsCleanerVersion(int[][] grid1, int[][] grid2) {
         int m = grid1.length;;
         int n = grid1[0].length;

         int countSubIsland = 0;
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (grid2[i][j] == 1 && countSubIslandsCleanerVersion(grid1, grid2, i, j)) {
                     countSubIsland++;
                 }
             }
         }

         return countSubIsland;
     }

     private boolean countSubIslandsCleanerVersion(int[][] grid1, int[][] grid2, int row, int col) {
         if (row < 0 || row >= grid1.length || col < 0 || col >= grid1[0].length) {
             return true;
         }

         if (grid2[row][col] == 0) {
             return  true;
         }

         grid2[row][col] = 0;

         boolean isSubIsland = true;
         isSubIsland &= countSubIslandsCleanerVersion(grid1, grid2, row + 1, col);
         isSubIsland &= countSubIslandsCleanerVersion(grid1, grid2, row - 1, col);
         isSubIsland &= countSubIslandsCleanerVersion(grid1, grid2, row, col + 1);
         isSubIsland &= countSubIslandsCleanerVersion(grid1, grid2, row, col - 1);

         return isSubIsland && (grid1[row][col] == 1);
     }

    public int countSubIslandsCleanerVersionWithoutInputModification(int[][] grid1, int[][] grid2) {
        int m = grid1.length;;
        int n = grid1[0].length;

        boolean[][] visited = new boolean[m][n];
        int countSubIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid2[i][j] == 1 && countSubIslandsCleanerVersionWithoutInputModificationHelper(grid1, grid2, visited, i, j)) {
                    countSubIsland++;
                }
            }
        }

        return countSubIsland;
    }

    private boolean countSubIslandsCleanerVersionWithoutInputModificationHelper(int[][] grid1, int[][] grid2, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid1.length || col < 0 || col >= grid1[0].length) {
            return true;
        }

        if (grid2[row][col] == 0) {
            return  true;
        }

        if (visited[row][col]) {
            return true;
        }

        visited[row][col] = true;

        boolean isSubIsLand = true;
        isSubIsLand &= countSubIslandsCleanerVersionWithoutInputModificationHelper(grid1, grid2, visited, row + 1, col);
        isSubIsLand &= countSubIslandsCleanerVersionWithoutInputModificationHelper(grid1, grid2, visited, row - 1, col);
        isSubIsLand &= countSubIslandsCleanerVersionWithoutInputModificationHelper(grid1, grid2, visited, row, col + 1);
        isSubIsLand &= countSubIslandsCleanerVersionWithoutInputModificationHelper(grid1, grid2, visited, row, col - 1);
        isSubIsLand &= (grid1[row][col] == 1);

        return isSubIsLand;
    }
}
