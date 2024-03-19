import java.util.*;

public class IsomorphicStrings {
    /*
    205.

    requirement:
    Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.

    test case:
    aba --> tbt
    abat --> tbtt?


    abc -> tbt
    solution:
    map:
    a -> t
    t -> a

    map[s[i]] = t[i]
    map[t]
    */

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();

        int[] map = new int[128];
        Arrays.fill(map, -1);

        boolean[] used = new boolean[128];

        for (int i = 0; i < n; i++) {
            int idx_S = s.charAt(i);
            int idx_T = t.charAt(i);
            if (map[idx_S] == -1) {
                if (!used[idx_T]) {
                    map[idx_S] = idx_T;
                    used[idx_T] = true;
                    continue;
                }
                return false;
            }
            if (map[idx_S] != idx_T) {
                return false;
            }
        }
        return true;
    }
}
