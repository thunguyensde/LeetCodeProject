import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    /*
    49.

    requirement:
    Given an array of strings strs, group the anagrams together.
    You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    test case:
    strs = ["aab", "aba", "abb", "aabc"]
    --> [["aab", "aba"], ["abb"], ["aabc"]]

    solution:
    - unique id for each word and its anagram
        - sorted order of the word: n word, mlogm * n
        - frequency of each character from 'a' --> 'z': 26 * n
    */

    public List<List<String>> groupAnagrams(List<String> strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String id = calculateIdOfWord(str);
            map.computeIfAbsent(id, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String calculateIdOfWord(String word) {
        int[] freqs = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freqs[word.charAt(i) - 'a']++;
        }
        StringBuilder id = new StringBuilder();
        for (int freq : freqs) {
            id.append(freq).append("/");
        }
        return id.toString();
    }

}
