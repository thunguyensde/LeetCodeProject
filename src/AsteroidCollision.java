import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    /*
    735.

    */

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();

        OUTER_LOOP: for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.peek();
                    if (top == asteroid * -1) {
                        stack.pop();
                        continue OUTER_LOOP;
                    } else if (top < asteroid * -1) {
                        stack.pop();
                    } else {
                        continue OUTER_LOOP;
                    }
                }
                stack.push(asteroid);
            }
        }

        int[] state = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            state[i--] = stack.pop();
        }

        return state;
    }
}
