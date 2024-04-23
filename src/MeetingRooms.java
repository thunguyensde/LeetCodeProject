import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    /*
    262.

    */

    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < n; i++) {
            int[] prevInterval = intervals[i - 1];
            int[] interval = intervals[i];
            if (interval[0] < prevInterval[1]) {
                return false;
            }
        }
        return true;
    }
}
