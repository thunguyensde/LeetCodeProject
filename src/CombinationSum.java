import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    /*
    39.

    requirement:
    Given an array of distinct integers candidates and a target integer target,
    return a list of all unique combinations of candidates where the chosen numbers sum to target.
    You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times.
    Two combinations are unique if the frequency of at least one of the chosen numbers is different.

    The test cases are generated such that the number of unique combinations
    that sum up to target is less than 150 combinations for the given input.

    test case:
    [1,2,3,4,5], target=6 --> [1,2,3], [1,5], [2,4]

    solutions:
    - backtracking

    dry run:

    complexity:
    - time: ?
    - space: ?
    */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new LinkedList<>();
        combinationSumHelper(candidates, 0, target, new LinkedList<>(), combinations);
        return combinations;
    }

    private void combinationSumHelper(int[] candidates, int index, int target, LinkedList<Integer> currentCombination, List<List<Integer>> combinations) {
        if(target == 0) {
            combinations.add(new LinkedList<>(currentCombination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            combinationSumHelper(candidates, i, target - candidates[i], currentCombination, combinations);
            currentCombination.removeLast();
        }
    }
}
