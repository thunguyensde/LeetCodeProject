import java.util.ArrayDeque;
import java.util.Deque;

public class SnakesAndLadders {
    /*
    909.

    test case:
    [[-1,-1,-1,-1,-1,-1],
    [-1,-1,-1,-1,-1,-1],
    [-1,-1,-1,-1,-1,-1],
    [-1,35,-1,-1,13,-1],
    [-1,-1,-1,-1,-1,-1],
    [-1,15,-1,-1,-1,-1]]

    1 --> [5][0]
    1/n = 0
    row: n - 1 - num/n
    col:
        row / 2 == 0
            num%n - 1
        row / 2 == 1
            n - num%n
    */

    public int minimumMoves(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        int numMoves = 0;
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num == n * n) {
                    return numMoves;
                }

                for (int dice = num + 1; dice <= Math.min(num + 6, n * n); dice++) {
                    int[] pos = getPosByNumber(dice, n);
                    int next = board[pos[0]][pos[1]] == -1 ? dice : board[pos[0]][pos[1]];
                    if (visited[next]) {
                        continue;
                    }
                    queue.add(next);
                    visited[next] = true;
                }
            }
            numMoves++;
        }

        return -1;
    }

    private int[] getPosByNumber(int num, int n) {
        int row = num % n == 0 ?
                n - num / n :
                n - 1 - num / n;

        int col = row % 2 == n % 2 ?
                n - 1 - (num - 1) % n:
                (num - 1) % n;

        return new int[]{row, col};
    }
}
