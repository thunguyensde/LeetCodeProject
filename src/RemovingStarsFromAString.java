import java.util.ArrayDeque;
import java.util.Deque;

public class RemovingStarsFromAString {
    /*
    2390.

    requirement:
    You are given a string s, which contains stars *.
    In one operation, you can:
        Choose a star in s.
        Remove the closest non-star character to its left, as well as remove the star itself.
        Return the string after all stars have been removed.
    Note:
        The input will be generated such that the operation is always possible.
        It can be shown that the resulting string will always be unique.

    test case:
    ab*c --> ac
    ab**c --> c

    solution:
    - stack
    */

    public String removeStars(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '*') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.reverse().toString();
    }
}
