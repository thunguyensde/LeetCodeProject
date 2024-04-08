import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SquaresOfASortedArray {
    /*
    977.

    requirement:
    Given an integer array nums sorted in non-decreasing order,
    return an array of the squares of each number sorted in non-decreasing order.

    test case:
    -4 -5 1 3
    1 9 16 25

    -4 -2 1 3
    1 4 9 16

    solution:
    - sorting: O(nlogn)
    - better: O(n)
    */

    public int[] squaresOfASortedArray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] squares = new int[n];
        int idx = n - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                squares[idx--] = nums[left] * nums[left];
                left++;
            } else {
                squares[idx--] = nums[right] * nums[right];
                right--;
            }
        }
        return squares;
    }
}
