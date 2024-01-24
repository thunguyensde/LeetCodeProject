import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;

public class MergeIntervals {
    /*
    56.

    requirement:
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.

    test case:
    [1,3], [2,4]
    [1,3], [3,5]
    [1,5], [2,4]
    [1,3], [1,5]

    solution:
    - sorting:
        + ascending by start

    dry run:

    complexity:
    - time: O(nlogn)
    - space: O(n)
    */

    public int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> intervalList = new ArrayList<>();
        int[] pivotInterval = Arrays.copyOf(intervals[0], 2);

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= pivotInterval[1]) {
                pivotInterval[1] = Math.max(pivotInterval[1], intervals[i][1]);
            } else {
                intervalList.add(pivotInterval);
                pivotInterval = Arrays.copyOf(intervals[i], 2);
            }
        }

        intervalList.add(pivotInterval);
        return intervalList.toArray(value -> new int[0][]);
    }
}
