import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    /*
    77.

    requirement:
    Given two integers n and k,
    return all possible combinations of k numbers chosen from the range [1, n].
    You may return the answer in any order.

    test case:
    n = 3
    k = 2
    [1,2,3]
    [1,2] [1,3] [2,3]

    [1,2,3,4]
    [1,2,3] [1,2,4] [1,3,4] [2,3,4]

    solution:
    - backtracking

    complexity:
    - time: mathematics
    - space: ?
    */

    public List<List<Integer>> generateCombinations(int n, int k) {
        List<List<Integer>> combinations = new LinkedList<>();
        generateCombinationsHelper(0, new LinkedList<>(), n, k, combinations);
        return combinations;
    }

    private void generateCombinationsHelper(int num, LinkedList<Integer> combination, int n, int k, List<List<Integer>> combinations) {
        if (combination.size() == k) {
            combinations.add(new LinkedList<>(combination));
            return;
        }
        for (int i = num + 1; i <= n - k + combination.size() + 1; i++) {
            combination.add(i);
            generateCombinationsHelper(i, combination, n, k, combinations);
            combination.removeLast();
        }
    }
}
