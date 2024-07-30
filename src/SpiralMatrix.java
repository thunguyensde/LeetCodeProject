import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /*
    54.

    */

    enum DIRECTION {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        // formula:
        // - int[] spiralOrder - int[][] matrix
        //     + spiralOrder[sth] = matrix[sth][sth]


        // --> [0,0] [0,1] [0,2] [0,3] [1,0] [1,1] [1,2] [1,3] [2,0] [2,1] [2,2] [2,3]
        // --> [0,0] [0,1] [0,2] [0,3] [1,3] [2,3] [2,2] [2,1] [2,0] [1,0] [1,1] [1,2]

        // 0  1  2  3
        // 4  5  6  7
        // 8  9  10 11

        // --> 0 1 2 3 4 5  6  7 8 9 10 11
        // --> 0 1 2 3 7 11 10 9 8 4 5  6

        // 0 1 2 3
        // 4 5 6 7
        // 8 9 10 11
        // 12 13 14 15

        // --> 0 1 2 3 4 5  6  7  8  9  10 11 12 13 14 15
        // --> 0 1 2 3 7 11 15 14 13 12 8  4  5  6  10 9

        List<Integer> spiralList = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int row = 0, col = 0;
        boolean[][] added = new boolean[m][n];
        DIRECTION dir = DIRECTION.RIGHT;

        while (spiralList.size() < size) {
            spiralList.add(matrix[row][col]);
            added[row][col] = true;

            int potentialNextRow = row, potentialNextCol = col;
            if (dir == DIRECTION.RIGHT) {
                potentialNextCol += 1;
            } else if (dir == DIRECTION.DOWN) {
                potentialNextRow += 1;
            } else if (dir == DIRECTION.LEFT) {
                potentialNextCol -= 1;
            } else { // dir == DIRECTION.UP
                potentialNextRow -= 1;
            }

            if (potentialNextRow >= m || potentialNextRow < 0 || potentialNextCol >= n || potentialNextCol < 0 || added[potentialNextRow][potentialNextCol]) {
                if (dir == DIRECTION.RIGHT) {
                    dir = DIRECTION.DOWN;
                } else if (dir == DIRECTION.DOWN) {
                    dir = DIRECTION.LEFT;
                } else if (dir == DIRECTION.LEFT) {
                    dir = DIRECTION.UP;
                } else { // dir == DIRECTION.UP
                    dir = DIRECTION.RIGHT;
                }
            }

            if (dir == DIRECTION.RIGHT) {
                col += 1;
            } else if (dir == DIRECTION.DOWN) {
                row += 1;
            } else if (dir == DIRECTION.LEFT) {
                col -= 1;
            } else { // dir == DIRECTION.UP
                row -= 1;
            }
        }

        return spiralList;
    }
}
