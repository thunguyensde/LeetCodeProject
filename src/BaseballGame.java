import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {
    /*
    682.

    requirement:
    You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
    You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

    An integer x.
    Record a new score of x.

    '+'.
    Record a new score that is the sum of the previous two scores.

    'D'.
    Record a new score that is the double of the previous score.

    'C'.
    Invalidate the previous score, removing it from the record.

    Return the sum of all the scores on the record after applying all the operations.
    The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.

    test case:
    5, 6, + --> 5, 6, 11 --> 22
    5, D --> 5, 10 --> 15
    5, 6, C --> 5

    solution:
    - stack

    dry run:

    complexity:
    - time: O(n)
    - space: O(n)
    */

    public int baseballGameScoreSum(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sumScore = 0;
        for (String op : operations) {
            if (op.equals("+")) {
                int secondRecord = stack.pop();
                int firstRecord = stack.pop();
                stack.push(firstRecord);
                stack.push(secondRecord);
                stack.push(firstRecord + secondRecord);
                sumScore += stack.peek();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
                sumScore += stack.peek();
            } else if (op.equals("C")) {
                sumScore -= stack.pop();
            } else {
                int record = Integer.parseInt(op);
                stack.push(record);
                sumScore += stack.peek();
            }
        }
        return sumScore;
    }
}
