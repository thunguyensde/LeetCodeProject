public class Sqrtx {
    /*
    69.

    */

    public int mySqrt(int x) {
        long left = 0;
        long right = x; // 8

        while (left <= right) {
            long mid = right + (left - right) / 2; // 1
            if (mid * mid == x) {
                return (int)mid;
            }
            if (mid * mid < x) {
                left = mid + 1; // 3
            } else {
                right = mid - 1; // 2
            }
        }
        return (int)right;
    }
}
