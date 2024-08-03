import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    /*
    2542.

    */

    public long maxScore(int[] nums1, int[] nums2, int k) {
        // [0,1,2,3,4]
        // [5,6,7,8,9]
        // k=3

        // score is sum(subset1) * min(subset2)
        // maxScore = max sum(subset1) * (n - k)th largest (subset2)

        // brute force:
        // get all size-k subsets of indices
        // sum of subset1: backtracking
        // min of subset2
        // find max product

        // min of subset2: 1,

        // {2,4} {3,3} {1,2} {3,1}
        // pair num for nums1 with nums2 with same index
        // {1,2} {3,1} {3,3} {2,4}

        // sort by nums2
        // {2,4} {3,3} {1,2} {3,1}

        // find (k - 1) max nums1 so far

        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long maxScore = Integer.MIN_VALUE;
        long maxCurSum = 0;
        for (int i = 0; i < n; i++) {
            if (minHeap.size() < k - 1) {
                minHeap.add(pairs[i][0]);
                maxCurSum += pairs[i][0];
                continue;
            }

            long score = pairs[i][1] * (maxCurSum + pairs[i][0]);
            maxScore = Math.max(maxScore, score);

            minHeap.add(pairs[i][0]);
            maxCurSum += pairs[i][0];
            maxCurSum -= minHeap.poll();
        }

        return maxScore;
    }

    // nums1, k, index, curSum {
    //     if (k == 0) {

    //     }
    //     for (int i = index + 1; i < n; i++) {
    //         curSum += nums1[i];
    //         backtracking(nums1, k - 1, i, curSum);
    //         curSum -= nums1[i];
    //     }
    // }
}
