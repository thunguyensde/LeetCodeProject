import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    /*
    452.

    */

    public int findMinArrowShots(int[][] points) {
        // [] [] [] [] [] [] []
        // [[]] [] []
        // [1,6] [2,6] [7,12] [10,16]
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        // [ [       ] [ ]    [     ]           ]

        // [1,6][2,8][7,12] --> 2

        // [1,6][2,8][6,12] --> 1

        // sorting
        // keep the min x-end
        // if xstart > min x-end, arrows++;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int n = points.length;

        long minXEnd = Long.MIN_VALUE;
        int arrows = 0;
        int i = 0;
        while (i < n) {
            int[] balloon = points[i];
            long xStart = balloon[0];
            long xEnd = balloon[1];
            if (xStart > minXEnd) {
                arrows++;
                minXEnd = xEnd;
            } else {
                minXEnd = Math.min(minXEnd, xEnd);
            }
            i++;
        }
        return arrows;
    }
}
