import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
    3.

    requirement:
    Given a string s, find the length of the longest substring without repeating characters.

    test case:
    - aaabcdee --> 5
    - abcdecfgh --> 6

    solution:
    - use hashmap, with <character,index>
    - startIndex
    - if exists in hashmao where index < startIndex --> find dup --> reset startIndex = index
    - special input:
        + a -> z or A -> Z: int[26]
        + ascii --> int[128]
        + extended ascii --> int[256]

    dry run:

    complexity:
    - time: O(n)
    - space: O(n)
    */
//    0 1 2 3 4 5 6 7 8
//    a b c d e c f g h
    public int findLengthOfLongestSubstringWithoutRepeatingCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>(); // {a,0} {b,1} {c,5} {d,3} {e,4}
        int startIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i)); // 2
            if (index != null && index >= startIndex) {
                maxLength = Math.max(maxLength, i - startIndex);
                startIndex = index + 1;
            }
            map.put(s.charAt(i), i);
        }
        return Math.max(maxLength, s.length() - startIndex);
    }
}
