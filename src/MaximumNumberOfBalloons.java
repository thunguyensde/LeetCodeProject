import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    /*
    1189.

    requirement:
    Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
    You can use each character in text at most once. Return the maximum number of instances that can be formed.

    test case:
    bal88loon
    */

    public int maximumNumberOfBalloons(String text) {
        Map<Character, Integer> balloon = new HashMap<>() {{
            put('b', 1);
            put('a', 1);
            put('l', 2);
            put('o', 2);
            put('n', 1);
        }};

        Map<Character, Integer> freqs = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (!balloon.containsKey(text.charAt(i))) {
                continue;
            }

            freqs.put(text.charAt(i), freqs.getOrDefault(text.charAt(i), 0) + 1);
        }

        if (freqs.size() != balloon.size()) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> pair : freqs.entrySet()) {
            count = Math.min(count, pair.getValue() / balloon.get(pair.getKey()));
        }

        return count;
    }
}
