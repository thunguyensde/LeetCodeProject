public class MoveZeros {
    /*
    283.

    requirement:
    Given an integer array nums,
    move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    test case:
    0 1 0 2 3
    --> 1 2 3 0 0

    0 1 2 3 0
    1 0 2 3 0

    */

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int writeIdx = 0;
        int readIdx = 0;
        while (readIdx < n) {
            if (nums[readIdx] != 0) {
                if (readIdx != writeIdx) {
                    int temp = nums[writeIdx];
                    nums[writeIdx] = nums[readIdx];
                    nums[readIdx] = temp;
                }
                writeIdx++;
            }
            readIdx++;
        }
    }
}
