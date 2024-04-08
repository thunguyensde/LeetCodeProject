import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    /*
    424.

    requirement:
    You are given a string s and an integer k.
    You can choose any character of the string and change it to any other uppercase English character.
    You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.

    Example 1:
    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

    Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exists other ways to achieve this answer too.

    test case:
    AABBBABBBB, k = 2
    BABBABA

    solution:
    - problem: longest substring with (length - most appeared characters) <= k
    - hashmap
    */

    public int longestRepeatingCharacterAfterReplacement(String s, int k) {
        int n = s.length();
        // frequencies of characters in current substring
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxFreq = 0;
        int maxLength = 0;
        while (end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            // max frequency of all characters traversed so far
            maxFreq = Math.max(maxFreq, map.get(s.charAt(end)));
            while (end - start + 1 - maxFreq > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
