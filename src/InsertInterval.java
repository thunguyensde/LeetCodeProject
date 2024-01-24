import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class InsertInterval {
    /*
    57.

    requirement:
    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
    represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
    and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

    Return intervals after the insertion.

    test case:
    [0,2][4,6][8,9]

    [3,3] -> [0,2][3,3][4,6][8,9]
    [1,3] -> [0,3][4,6][8,9]
    [3,5] -> [0,2][3,6][8,9]
    [1,5] -> [0,6][8,9]

    solution:
    binary search
    find an interval where it includes newInterval[0], if can't find, return right
    find an interval where it includes newInterval[1], if can't find, return left

    dry run:

    complexity:
    - time: O(n)
    - space: O(n)
    */

    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        if (n == 0) {
            return new int[][]{newInterval};
        }

        if (newInterval[0] > intervals[n - 1][1]) {
            int[][] insertedArray = new int[n + 1][];
            for (int i = 0; i < n; i++) {
                insertedArray[i] = intervals[i];
            }
            insertedArray[n] = newInterval;
            return insertedArray;
        }

        if (newInterval[1] < intervals[0][0]) {
            int[][] insertedArray = new int[n + 1][];
            insertedArray[0] = newInterval;
            for (int i = 1; i <= n; i++) {
                insertedArray[i] = intervals[i - 1];
            }
            return insertedArray;
        }

        int lowerBoundIntervalIndex = binarySearchOnIntervals(intervals, newInterval[0], true); // 1
        int upperBoundIntervalIndex = binarySearchOnIntervals(intervals, newInterval[1], false); // 0

        List<int[]> intervalList = new ArrayList<>();
        for (int i = 0; i < lowerBoundIntervalIndex; i++) {
            intervalList.add(intervals[i]);
        }
        intervalList.add(new int[]{
                Math.min(newInterval[0], intervals[lowerBoundIntervalIndex][0]),
                Math.max(newInterval[1], intervals[upperBoundIntervalIndex][1])
        });
        for (int i = upperBoundIntervalIndex + 1; i < n; i++) {
            intervalList.add(intervals[i]);
        }

        return intervalList.toArray(value -> new int[0][]);
    }

    private int binarySearchOnIntervals(int[][] intervals, int num, boolean returnUpperBoundIfNotFound) {
        int left = 0;
        int right = intervals.length - 1;
        while (left <= right) {
            int mid = right + (left - right) / 2;
            if (intervals[mid][0] <= num && intervals[mid][1] >= num) {
                return mid;
            }
            if (intervals[mid][0] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return returnUpperBoundIfNotFound ? left : right;
    }

    // TODO: Enhance based on this solution
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> result = new LinkedList<>();
//        int i = 0;
//        // add all the intervals ending before newInterval starts
//        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
//            result.add(intervals.get(i++));
//        // merge all overlapping intervals to one considering newInterval
//        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
//            newInterval = new Interval( // we could mutate newInterval here also
//                    Math.min(newInterval.start, intervals.get(i).start),
//                    Math.max(newInterval.end, intervals.get(i).end));
//            i++;
//        }
//        result.add(newInterval); // add the union of intervals we got
//        // add all the rest
//        while (i < intervals.size()) result.add(intervals.get(i++));
//        return result;
//    }
}
