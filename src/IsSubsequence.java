import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class IsSubsequence {
    /*
    392.

    requirement:
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
    of the characters without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
    and you want to check one by one to see if t has its subsequence.
    In this scenario, how would you change your code?
    
    test case:
    ace
    abcde

    ace
    acce
    */

    // time: O(t)
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    // time: O(k*t)
    public boolean[] areAllSubsequence(String[] strs, String t) {
        int k = strs.length;
        boolean[] ans = new boolean[k];
        for (int i = 0; i < k; i++) {
            ans[i] = isSubsequence(strs[i], t);
        }
        return ans;
    }

//
//    acce
//    abcdce
// a: [0]
// b: [1]
// c: [2,4]
// d: [3]
// e: [5]

    // time: O(t + k*s*logt)
    public boolean[] fasterAreAllSubsequence(String[] strs, String t) {
        int k = strs.length;
        boolean[] ans = new boolean[k];

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.computeIfAbsent(t.charAt(i), key -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < k; i++) {
            ans[i] = fasterAreAllSubsequenceHelper(strs[i], map);
        }

        return ans;
    }

    private boolean fasterAreAllSubsequenceHelper(String s, Map<Character, List<Integer>> map) {
        int curIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.get(s.charAt(i));
            if (list == null) {
                return false;
            }
            int foundIdx = binarySearchUpperBound(list, curIdx);
            if (foundIdx == -1) {
                return false;
            }
            curIdx = foundIdx;
        }
        return true;
    }
    // 0 1 2 3 4
    // 1 4 5 8 9

    private int binarySearchUpperBound(List<Integer> list, int curIdx) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= curIdx) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left == list.size() ? -1 : list.get(left);
    }
}
