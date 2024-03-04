public class ArrangingCoins {
    /*
    441.

    requirement:
    You have n coins and you want to build a staircase with these coins.
    The staircase consists of k rows where the ith row has exactly i coins.
    The last row of the staircase may be incomplete.

    Given the integer n, return the number of complete rows of the staircase you will build.

    test case:
    n = 5 --> 2
    O
    OO
    OO

    n = 10 --> 4
    O
    OO
    OOO
    OOOO

    solution:
    - straightforward
        + n - 1, n - 2, n - k, where n - k < 0
        + complexity: time O(n)
    - binary search + math
        + sum[1...n] = (n + 1) * n / 2

    dry run:

    complexity:
    - time: O(n - k)
    - space: O(1)
    */

    public int calculateNumberOfCompleteRows(int n) {
        int i = 0;
        while (n >= 0) {
            i++; // 5
            n -= i; // -5
        }
        return i - 1;
    }

    public int calculateNumberOfCompleteRowsWithBinarySearchAndMaths(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = right + (left - right) / 2;
            long sum = ((long)mid * ((long)mid + 1)) / 2;
            if (sum == n) {
                return mid;
            }
            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
