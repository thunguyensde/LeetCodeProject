import java.util.*;

public class PathWithMaximumProbability {
    /*
    1514.

    */

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new double[]{edge[0], edge[1], succProb[i]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new double[]{edge[1], edge[0], succProb[i]});
        }

        double[] probs = new double[n];
        probs[start_node] = 1;

        PriorityQueue<double[]> heap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        heap.add(new double[]{start_node, probs[start_node]});

        while (!heap.isEmpty()) {
            double[] top = heap.poll();
            int node = (int)top[0];
            double prob = top[1];

            if (node == end_node) {
                return probs[end_node];
            }
            for (double[] adj : graph.getOrDefault(node, new ArrayList<>())) {
                int adjNode = (int)adj[1];
                double adjProb = adj[2];
                if (prob * adjProb > probs[adjNode]) {
                    probs[adjNode] = prob * adjProb;
                    heap.add(new double[]{adjNode, probs[adjNode]});
                }
            }
        }
        return 0;
    }
}
