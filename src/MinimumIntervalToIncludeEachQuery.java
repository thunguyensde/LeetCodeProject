import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEachQuery {
    /*
    1851.

    */

    public int[] minInterval(int[][] intervals, int[] queries) {
        // 2 conditions:
        // - between left and right (1)
        // - smallest size (2)

        // bruteforce: O(MN)

        // Map<Integer, Integer> map: key=query, value=result --> enable sorting ability

        // sort queries

        // sort intervals:
        // sort by left --> more chances to satisfy (1)
        // if equals, sort by right --> more changes to satisfy (2)

        // queries[i]
        // search till intervals[i][left] > queries[i]

        // all of intervals[i] having left <= queries[i] && queries <= right

        // [1,6] [2,4]
        // 2, 5

        // [0,3][2,4]
        // 2 3

        // if intervals[i] don't satisfy (1) for queries[i], then it wont satisfy all queries[i + 1], ...

        // smallest right
        // fit right --> fit left (largest left)

        int m = intervals.length;
        int n = queries.length;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = queries[i];
        }

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(queries);
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[1] - a[0] + 1) - (b[1] - b[0] + 1));

        int i = 0;
        for (int query : queries) {
            for (; i < m && intervals[i][0] <= query; i++) {
                heap.add(intervals[i]);
            }

            while (!heap.isEmpty() && heap.peek()[1] < query) {
                heap.poll();
            }

            if (heap.isEmpty()) {
                map.put(query, -1);
                continue;
            }

            map.put(query, heap.peek()[1] - heap.peek()[0] + 1);
        }

        for (i = 0; i < n; i++) {
            ans[i] = map.get(ans[i]);
        }

        return ans;

        // [1,8] [2,3] [2,5] [20,25]

        // 2 5 19 22

        // [2,5] [1,8]
    }
}
