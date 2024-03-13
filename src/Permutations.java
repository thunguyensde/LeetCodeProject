import java.util.LinkedList;
import java.util.List;

public class Permutations {
    /*
    46.

    requirement:
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.

    test case:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]

    solution:
    - boolean array to keep track of used/unused integer
    - backtracking
    */

    List<List<Integer>> generatePermutations(int[] nums) {
        int n = nums.length;
        List<List<Integer>> permutations = new LinkedList<>();
        boolean[] used = new boolean[n];
        generatePermutationsHelper(nums, used, new LinkedList<>(), permutations);
        return permutations;
    }

    private void generatePermutationsHelper(int[] nums, boolean[] used, LinkedList<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new LinkedList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                permutation.add(nums[i]);
                used[i] = true;
                generatePermutationsHelper(nums, used, permutation, permutations);
                permutation.removeLast();
                used[i] = false;
            }
        }
    }
}
