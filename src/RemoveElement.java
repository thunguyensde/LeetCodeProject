public class RemoveElement {
    /*
    27.

    requirement:
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

    Consider the number of elements in nums which are not equal to val be k, to get accepted,
    you need to do the following things:
        Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
        The remaining elements of nums are not important as well as the size of nums.
        Return k.

    test case:
    [1,2,2,2,3] --> [1,3,2,2,2]

    solution:
    - 2 pointers:
        - read
        - write
    */

    public int removeElementInPlace(int[] nums, int val) {
        int n = nums.length;
        int read = 0;
        int write = 0;
        for (; read < n; read++) {
            if (nums[read] != val) {
                nums[write++] = nums[read];
            }
        }
        return write;
    }
}
