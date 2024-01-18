import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    /*
    78.

    requirement:
    Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

    test case:
    [1,2,3] -> {}, {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}

    solution:
    backtracking

    dry run:

    complexity:
    - time: O(2^n)
    - space: O(n)
    */
    public List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> powerSet = new LinkedList<>();
        generateSubsetsHelper(nums, -1, new LinkedList<>(), powerSet);
        return powerSet;
    }

    private void generateSubsetsHelper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> powerSet) {
        powerSet.add(new LinkedList<>(subset)); // {}, {1}, {1,2}, {1,2,3}, ...
        for (int i = index + 1; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubsetsHelper(nums, i, subset, powerSet);
            subset.removeLast();
        }
    }
}
