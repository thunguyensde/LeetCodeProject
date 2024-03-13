import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    /*
    118.

    requirement:
    Given an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    test case:
    0 1 0
     1 1

    0 1 1 0
     1 2 1

    l2[0] = 0 + l1[0]
    l2[1] = l1[0] + 0

    l3[0] = 0 + l2[0]
    l3[1] = l2[0] + l2[1]
    l3[2] = l2[1] + 0

    ln[0] = ln-1[0]
    ln[i] = ln-1[i - 1] + ln-1[i]
    ln[n - 1] = ln-1[n - 2]

    solution:

    dry run:

    complexity:
    - time: n^2
    - space: n^2
    */

    List<List<Integer>> generateLevelsOfPascalsTriangle(int n) {
        List<List<Integer>> levels = new ArrayList<>();
        levels.add(new ArrayList<>(){{
            add(1);
        }});
        for (int i = 1; i < n; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int leftAboveNumber = j == 0 ? 0 : levels.get(i - 1).get(j - 1);
                int rightAboveNumber = j == i ? 0 : levels.get(i - 1).get(j);
                level.add(leftAboveNumber + rightAboveNumber);
            }
            levels.add(level);
        }
        return levels;
    }
}
