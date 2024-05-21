import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequence {
    /*
    946.

    */

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int poppedIdx = 0;
        int pushedIdx = 0;
        int n = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();
        while (poppedIdx < n) {
            while (stack.isEmpty() || stack.peek() != popped[poppedIdx]) {
                if (pushedIdx == n) return false;
                stack.push(pushed[pushedIdx]);
                pushedIdx++;
            }
            stack.pop();
            poppedIdx++;
        }
        return true;
    }
}
