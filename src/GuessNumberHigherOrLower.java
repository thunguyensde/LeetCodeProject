public class GuessNumberHigherOrLower {
    /*
    374.

    requirement:
    We are playing the Guess Game. The game is as follows:
        I pick a number from 1 to n. You have to guess which number I picked.
        Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
        You call a pre-defined API int guess(int num), which returns three possible results:
            -1: Your guess is higher than the number I picked (i.e. num > pick).
            1: Your guess is lower than the number I picked (i.e. num < pick).
            0: your guess is equal to the number I picked (i.e. num == pick).
    Return the number that I picked.

    test case:
    n = 10
    pickedNum = 8

    solution:
    - binary search

    dry run:

    complexity:
    - time: O(logn)
    - space: O(1)
    */


    int pickedNum = 8;

    public int guessPickedNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    private int guess(int num) {
        return Integer.compare(pickedNum, num);
    }
}
