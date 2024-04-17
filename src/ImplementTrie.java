import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {
    /*
    208.

    requirement:
    A trie (pronounced as "try") or prefix tree is a tree data structure used to
    efficiently store and retrieve keys in a dataset of strings.
    There are various applications of this data structure, such as autocomplete and spellchecker.
    Implement the Trie class:
        Trie() Initializes the trie object.
        void insert(String word) Inserts the string word into the trie.
        boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
            and false otherwise.
        boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix,
            and false otherwise.
    */

    public static class Trie {
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

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                node = node.children.get(prefix.charAt(i));
                if (node == null) {
                    return false;
                }
            }
            return true;
        }
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
