public class ValidPerfectSquare {
    /*
    367.

    requirement:
    Given a positive integer num, return true if num is a perfect square or false otherwise.
    A perfect square is an integer that is the square of an integer.
    In other words, it is the product of some integer with itself.
    You must not use any built-in library function, such as sqrt.

    test case:
    16 -> 4 (true)
    */
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num % mid == 0 && num / mid == mid) {
                return true;
            }
            if (mid < num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
