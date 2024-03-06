import java.util.*;

public class ReorderRoutes {
    /*
    1466.

    requirement:
    There are n cities numbered from 0 to n - 1 and n - 1 roads
    such that there is only one way to travel between two different cities (this network form a tree).
    Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

    Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
    This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
    Your task consists of reorienting some roads such that each city can visit the city 0.
    Return the minimum number of edges changed.

    It's guaranteed that each city can reach city 0 after reorder.

    test case:
    0 1
    2 3

    solution:
    - breadth first search
    - start with 0, get adjacent city to zeros
        + Map<int, int> undirectedGraph
    - check if that road needed reordering
        + Map<int, int> directedGraph

    dry run:

    complexity:
    - time: O(n)
    - space: O(n)
    */

    public int reorderRoutes(int n, int[][] connections) {
        //
        Map<Integer, List<Integer>> undirectedGraph = new HashMap<>();
        Map<Integer, Set<Integer>> directedGraph = new HashMap<>();
        for (int[] con : connections) {
            undirectedGraph.computeIfAbsent(con[0], k -> new ArrayList<>()).add(con[1]);
            undirectedGraph.computeIfAbsent(con[1], k -> new ArrayList<>()).add(con[0]);

            directedGraph.computeIfAbsent(con[0], k -> new HashSet<>()).add(con[1]);
        }

        int numReorderingRoute = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int city = queue.poll();
                List<Integer> neighboringCities = undirectedGraph.get(city);
                for (int neighboringCity : neighboringCities) {
                    if (visited.contains(neighboringCity)) continue;
                    if (directedGraph.get(neighboringCity) == null || !directedGraph.get(neighboringCity).contains(city)) {
                        numReorderingRoute++;
                    }
                    queue.add(neighboringCity);
                    visited.add(neighboringCity);
                }
            }
        }
        return numReorderingRoute;
    }
}
