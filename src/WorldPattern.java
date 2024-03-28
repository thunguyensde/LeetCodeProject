import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorldPattern {
    /*
    290.

    requirement:
    Given a pattern and a string s, find if s follows the same pattern.
    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

    test case:
    a b b a <-> dog cat cat dog --> true
    a b <-> dog dog --> false

    solution:
    - hashmap<character, string>
    - set<string>
    */

    public boolean worldPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        int n = pattern.length();
        Map<Character, String> map = new HashMap<>();
        Set<String> taken = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = map.get(pattern.charAt(i)); // null
            if (str != null && !str.equals(strs[i])) {
                return false;
            }
            if (str == null && taken.contains(strs[i])) {
                return false;
            }
            map.put(pattern.charAt(i), strs[i]);
            taken.add(strs[i]);
        }
        return true;
    }
}
