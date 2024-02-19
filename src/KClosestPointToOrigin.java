import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KClosestPointToOrigin {
    /*
    973.

    requirements:
    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
    return the k closest points to the origin (0, 0).
    The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

    test case:
    [0,1] [0,2] [0,0] k=2 --> [0,0] [0,1]

    solution:
    - max heap of size k: O(nlogk)
    - quick select: best O(n), worst O(n^2)

    dry run:

    complexity:
    - time: O(nlogk)
    - space: O(n)
    */

    public int[][] getKClosestPointToOrigin(int[][] points, int k) {
        int n = points.length;
        double[] distances = new double[n];
        for (int i = 0; i < n; i++) {
            double distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            distances[i] = distance;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> Double.compare(distances[j], distances[i]));

        for (int i = 0; i < n; i++) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] kClosestPoints = new int[k][];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            kClosestPoints[i++] = points[maxHeap.poll()];
        }

        return kClosestPoints;
    }

    // k = 4
    // 0 1 2 3 4 5
    // 8 5 1 7 3 6 --> pivot = 6
    // 5 1 3 6 8 7
    public int[][] quickSelectGetKClosestPointToOrigin(int[][] points, int k) {
        int n = points.length;
        quickSelect(points, k, 0, n - 1);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void quickSelect(int[][] points, int k, int left, int right) {
        int partitionIndex = partition(points, left, right);
        if (partitionIndex == k - 1) {
            return;
        }
        if (partitionIndex < k - 1) {
            quickSelect(points, k, partitionIndex + 1, right);
        } else {
            quickSelect(points, k, left, partitionIndex - 1);
        }
    }

    // 0 1 2 3 4 5
    // 8 5 1 7 3 6 --> pivot = 6
    // 5 1 3 6 8 7
    private int partition(int[][] points, int left, int right) {
        int randomPosition = new Random().nextInt(right - left + 1) + left;
        swap(points, randomPosition, right);
        int[] pivotPoint = points[right];
        double distanceOfPivotPoint = calculateDistance(pivotPoint);

        int partitionIndex = left;
        for (int i = left; i <= right; i++) {
            if (calculateDistance(points[i]) <= distanceOfPivotPoint) {
                swap(points, i, partitionIndex++);
            }
        }
        return partitionIndex - 1;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private double calculateDistance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}
