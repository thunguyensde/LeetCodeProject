import java.util.Arrays;
import java.util.Comparator;

public class MinCostToConnectAllPoints {
    /*
    1584.

    notes:
    solve with Kruskal
    haven't solved with Prim, which when optimized runs a bit faster: O(v^2)
    */

    public int minCostConnectPoints(int[][] points) {
        int numVertices = points.length;
        int[][] edges = new int[(numVertices * (numVertices - 1)) / 2][3];
        for (int i = 0, idx = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                edges[idx++] = new int[]{i, j, calDis(points, i, j)};
            }
        }
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        UnionFind uf = new UnionFind(numVertices);
        int cost = 0;
        for (int[] edge : edges) {
            boolean canUnion = uf.union(edge[0], edge[1]);
            if (canUnion) {
                cost += edge[2];
            }
        }
        return cost;
    }

    private int calDis(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
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

        boolean union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return false;
            }
            if (rank[parentX] == rank[parentY]) {
                parent[parentX] = parent[parentY];
                rank[parentY]++;
            } else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else {
                parent[parentY] = parentX;
            }
            return true;
        }
    }
}
