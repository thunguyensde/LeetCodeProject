import java.util.*;

public class NetworkDelayTime {
    /*
    743.

    */
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], key -> new ArrayList<>()).add(time);
        }

        int[] minTimes = new int[n + 1];
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        minTimes[k] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.add(new int[]{k, 0});

        while(!heap.isEmpty()) {
            int node = heap.poll()[0];
            List<int[]> adjNodes = graph.getOrDefault(node, new ArrayList<>());
            for (int[] adjNode : adjNodes) {
                if (minTimes[node] + adjNode[2] < minTimes[adjNode[1]]) {
                    minTimes[adjNode[1]] = minTimes[node] + adjNode[2];
                    heap.add(new int[]{adjNode[1], minTimes[adjNode[1]]});
                }
            }
        }

        int minimumTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int time = minTimes[i];
            if (time == Integer.MAX_VALUE) {
                return -1;
            }
            minimumTime = Math.max(minimumTime, time);
        }

        return minimumTime;
    }
}
