import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    /*
    253.

    */

     public int minMeetingRooms(int[][] intervals) {
         Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

         int n = intervals.length;

         PriorityQueue<int[]> minEndTimeHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

         for (int[] interval : intervals) {
             if (!minEndTimeHeap.isEmpty() && minEndTimeHeap.peek()[1] <= interval[0]) {
                 minEndTimeHeap.poll();
             }
             minEndTimeHeap.add(interval);
         }

         return minEndTimeHeap.size();
     }

    public int myMinMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;

        PriorityQueue<int[]> minEndTimeHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int minRooms = 1;

        for (int[] interval : intervals) {
            while (!minEndTimeHeap.isEmpty() && minEndTimeHeap.peek()[1] <= interval[0]) {
                minEndTimeHeap.poll();
            }
            minEndTimeHeap.add(interval);
            minRooms = Math.max(minEndTimeHeap.size(), minRooms);
        }

        return minRooms;
    }
}
