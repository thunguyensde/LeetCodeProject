import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    /*
    40.

    requirement:
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.
    Note: The solution set must not contain duplicate combinations.

    test case:
    [1,1,2] target=3 --> [1,2]
    [1,1,1,2] target=3 --> [1,2], [1,1,1]
    solution:
    - sort
    - backtracking

    dry run:

    complexity:
    - time: ?
    - space: ?
    */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new LinkedList<>();
        combinationSumHelper(candidates, -1, target, new LinkedList<>(), combinations);
        return combinations;
    }

    private void combinationSumHelper(int[] candidates, int index, int target, LinkedList<Integer> currentCombination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new LinkedList<>(currentCombination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            if (i == index + 1 || candidates[i] != candidates[i - 1]) {
                currentCombination.add(candidates[i]);
                combinationSumHelper(candidates, i, target - candidates[i], currentCombination, combinations);
                currentCombination.removeLast();
            }
        }
    }
}
