import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    /*
    435.

    requirement:
    Given an array of intervals intervals where intervals[i] = [starti, endi],
    return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

    test case:
    [1,6],[2,4],...
    [0,2],[1,6],[3,8],...
    [0,2],[1,6],[1,8],...

    solution:
    - sorting
        + ascending start
    - greedy approach
        + keeping interval with smaller end

    dry run:

    complexity:
    - time: O(nlogn)
    - space: O(1)
    */

    public int getMinimumIntervalsRemovedToBeNonOverlapping(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int upperBoundOfNearestToTheLeftInterval = intervals[0][1];
        int numberOfIntervalsRemoved = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < upperBoundOfNearestToTheLeftInterval) {
                numberOfIntervalsRemoved++;
                upperBoundOfNearestToTheLeftInterval = Math.min(upperBoundOfNearestToTheLeftInterval, intervals[i][1]);
            } else {
                upperBoundOfNearestToTheLeftInterval = intervals[i][1];
            }
        }
        return numberOfIntervalsRemoved;
    }
}
