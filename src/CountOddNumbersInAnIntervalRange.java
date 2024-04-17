public class CountOddNumbersInAnIntervalRange {
    /*
    1523.

    requirement:
    Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

    test case:
    low=0, high=5 --> 1,3,5 --> 3
    low=1, high=6 --> 1,3,5 --> 3
    low=1, high=5 --> 1,3,5 --> 3
    low=0, high=6 --> 1,3,5 --> 3
    */

    public int countOddNumbersInAnIntervalRange(int low, int high) {
        return ((high - low) + high % 2 + low % 2) / 2;
    }
}
