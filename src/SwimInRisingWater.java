import java.util.PriorityQueue;

public class SwimInRisingWater {
    /*
    778.

    */

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        heap.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] nbs = new int[]{-1, 0, 1, 0, -1};
        int ans = 0;
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            ans = Math.max(ans, grid[top[0]][top[1]]);
            if (top[0] == n - 1 && top[1] == n - 1) {
                return ans;
            }
            for (int i = 0; i < nbs.length - 1; i++) {
                int r = top[0] + nbs[i];
                int c = top[1] + nbs[i + 1];
                if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c]) {
                    continue;
                }

                heap.add(new int[]{r, c});
                visited[r][c] = true;
            }
        }
        return ans;
    }
}
