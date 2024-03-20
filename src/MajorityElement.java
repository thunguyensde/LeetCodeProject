public class MajorityElement {
    /*
    169.

    requirement:
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times.
    You may assume that the majority element always exists in the array.

    test case:
    - 1 2 2 2 3

    solution:
    - hashset
    - sorting
    - O(n) time - O(1) space
    */

    public int findMajorityElement(int[] nums) {
        int n = nums.length;
        int candidate = nums[0];
        int occurences = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == candidate) {
                occurences++;
            } else {
                occurences--;
            }
            if (occurences == 0) {
                candidate = nums[i];
                occurences = 1;
            }
        }
        return candidate;
    }
}
