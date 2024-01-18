import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2 {
    /*
    90.

    requirement:
    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

    test case:
    [1,2,2] -> {},{1},{2},{1,2},{2,2},{1,2,2}
    [1,1} -> {},{1},{1,1}
    [1,2,2,2,3] -> {},{1},{2},{3},{1,2},{1,3},{2,2},{2,3},{1,2,3},{2,2,3},{1,2,2,3},{1,2,2,2},{2,2,2,3},{1,2,2,2,3}
    [1,2,2,  2,2,3]
    [2,1,2] -> {},{2},{1}
    [2,2,3,2,1] -> {2,2}, {2,2} --> reason why need sorting!
    solution:
    - sorting
    - backtracking
    - while looping the array if nums[i] = nums[i - 1]: continue
    */

    public List<List<Integer>> generateSubsetsOfArrayContainDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> powerSet = new LinkedList<>();
        generateSubsetsOfArrayContainDuplicateHelper(nums, -1, new LinkedList<>(), powerSet);
        return powerSet;
    }

    public void generateSubsetsOfArrayContainDuplicateHelper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> powerSet) {
        powerSet.add(new LinkedList<>(subset));
        for (int i = index + 1; i < nums.length; i++) {
            if (i > index + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            generateSubsetsOfArrayContainDuplicateHelper(nums, i, subset, powerSet);
            subset.removeLast();
        }
    }
}
