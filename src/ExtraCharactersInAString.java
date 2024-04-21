import java.util.HashMap;
import java.util.Map;

public class ExtraCharactersInAString {
    /*
    2707.

    notes:
    solved with finding dp[n + 1]: O(N^3)
    optimized solution is to find dp[0], meaning going backward: O(N^2)
    */

    public int minExtraChar(String s, String[] dictionary) {
        // overlappinggg
        // overlap: found, pinggg: not found --> 6
        // over: not found, lappinggg: found --> 4
        // dp[i]: min characters left over from [0, i]
        // dp[0]: 1 if s[0] not found, 0 if s[0] found
        // dp[i]: if s[0,i] found --> 0 else
        //        dp[i - 1] + 1 (if s[i] not found)
        //        dp[i - 1] + 0 (if s[i] found)
        //        dp[i - 2] + 2 (if s[i - 1, i] not found)
        //        dp[i - 2] + 0 (if s[i - 1, i] found)
        // ...
        // dp[i]: Math.min(...)
        // return dp[n + 1];

        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = n;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(
                        dp[i],
                        trie.search(s.substring(j, i)) ? dp[j] : dp[j] + (i - j)
                );
            }
        }
        return dp[n];
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                node = node.children.computeIfAbsent(word.charAt(i), k -> new TrieNode());
            }
            node.isAFullWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                node = node.children.get(word.charAt(i));
                if (node == null) {
                    return false;
                }
            }
            return node.isAFullWord;
        }

        public static class TrieNode {
            Map<Character, TrieNode> children;
            boolean isAFullWord;

            public TrieNode() {
                this.children = new HashMap<>();
                this.isAFullWord = false;
            }
        }
    }
}
