import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    /*
    1631.

    requirement:
    You are a hiker preparing for an upcoming hike.
    You are given heights, a 2D array of size rows x columns,
    where heights[row][col] represents the height of cell (row, col).
    You are situated in the top-left cell, (0, 0),
    and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
    You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

    A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
    Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

    test case:

    solution:
    - dfs
    */

    public int minimumEffortPathWithDijkstra(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] adjs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

        int[][] diffs = new int[m][n];
        for (int[] row : diffs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        diffs[0][0] = 0;
        heap.add(new int[]{0, 0, 0});

        while (true) {
            int[] top = heap.poll();
            int row = top[0], col = top[1], diff = top[2];

            if (row == m - 1 && col == n - 1) {
                return diffs[row][col];
            }

            for (int[] adj : adjs) {
                int adjRow = row + adj[0];
                int adjCol = col + adj[1];
                if (adjRow < 0 || adjRow >= m || adjCol < 0 || adjCol >= n) {
                    continue;
                }
                int newDiff = Math.max(Math.abs(heights[adjRow][adjCol] - heights[row][col]), diffs[row][col]);
                if (newDiff < diffs[adjRow][adjCol]) {
                    diffs[adjRow][adjCol] = newDiff;
                    heap.add(new int[]{adjRow, adjCol, newDiff});
                }
            }
        }
    }

    // The idea comes from finding minimum spanning tree of weighted graph
    public int minimumEffortPathWithUnionFind(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int numEdges = m * (n - 1) + n * (m - 1);
        int numVertices = m * n;
        int[][] edges = new int[numEdges][3];
        int i = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n - 1; c++) {
                edges[i++] = new int[]{
                        n * r + c,
                        n * r + c + 1,
                        Math.abs(heights[r][c] - heights[r][c + 1])
                };
            }
        }
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < m - 1; r++) {
                edges[i++] = new int[]{
                        n * r + c,
                        n * (r + 1) + c,
                        Math.abs(heights[r][c] - heights[r + 1][c])
                };
            }
        }
        Arrays.sort(edges, (e1, e2) -> e1[2] - e2[2]);

        UnionFind uf = new UnionFind(numVertices);
        int diff = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
            diff = Math.max(diff, edge[2]);
            if (uf.find(0) == uf.find(numVertices - 1)) {
                return diff;
            }
        }
        return 0;
    }

    public static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return parent[x];
        }

        void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return;
            }
            if (rank[parentX] == rank[parentY]) {
                parent[parentX] = parent[parentY];
                rank[parentY]++;
            } else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else {
                parent[parentY] = parentX;
            }
        }
    }
}
