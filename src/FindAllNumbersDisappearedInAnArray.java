import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    /*
    448.

    requirement:
    Given an array nums of n integers where nums[i] is in the range [1, n],
    return an array of all the integers in the range [1, n] that do not appear in nums.

    test case:
    1 1 1 1 1
    1 2 2 3 4

    */

    public List<Integer> findDisappearedNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
