import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    /*
    149.


    */

    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 1;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int[] x = points[i];
                int[] y = points[j];
                double slope = (x[0] == y[0]) ?
                        Double.MAX_VALUE : // tan(x) range from ... to ... ; x / 0 -> mathematically wrong
                        (x[1] == y[1]) ?
                                0.0 : // 0 / negative number = -0 ; 0 / positive number = 0
                                (double) (x[1] - y[1]) / (double) (x[0] - y[0]); // int / int = int
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                max = Math.max(map.get(slope), max);
            }
        }
        return max;
    }
}
