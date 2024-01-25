import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {
    /*
    219.

    requirement:
    Given an integer array nums and an integer k,
    return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

    test case:
    [0 1 2 3 4]
    [1 5 8 1 9] & k=[0, 2] --> false
    [1 5 8 1 9] & k=[3, 4] --> true

    [0 1 2 3 4]
    [1 5 8 1 9] & k=[0, 3] --> true
    [1 5 8 1 9] & k=[0, 4] --> false

    solution:
    - hashmap

    complexity:
    - time: O(n)
    - space: O(n)
    */

    public boolean isDuplicateWithAtMostKDistance(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean isDuplicateWithAtMostKDistanceWithEnhancement(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
