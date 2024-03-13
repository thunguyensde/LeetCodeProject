import java.util.*;

public class Permutations2 {
    /*
    47.

    requirement:
    Given a collection of numbers, nums, that might contain duplicates,
    return all possible unique permutations in any order.

    test case:
    [1,1,2], [1,2,1], [2,1,1]
    [1,1,2], [1,2,1], [1,1,2], [1,2,1], [2,1,1], [2,1,1]

    [1,2,2], [2,1,2], [2,2,1]

    solution:
    - extra: sorting first
    */

    public List<List<Integer>> uniquePermutations(int[] nums) {
        int n = nums.length;
        List<List<Integer>> permutations = new LinkedList<>();
        boolean[] used = new boolean[n];
        generatePermutationsHelper(nums, used, new LinkedList<>(), permutations);
        return permutations;
    }

    // 1
    private void generatePermutationsHelper(int[] nums, boolean[] used, LinkedList<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new LinkedList<>(permutation));
            return;
        }
        Set<Integer> usedInThisLevel = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || usedInThisLevel.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            used[i] = true;
            generatePermutationsHelper(nums, used, permutation, permutations);
            permutation.removeLast();
            used[i] = false;
            usedInThisLevel.add(nums[i]);
        }
    }

    // 2
    /*
    Instead of Set<Integer> usedInThisLevel = new HashSet<>()
    Sort then check if(i>0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
    */

    // 3
    /*
    Solve just like with distinct integers, use Set<List<Integer>> to remove duplicate
    */

    // 4
    /*
    Use HashMap to store frequencies, decrease frequency after each usage of an integer
    */
}
