import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {
    /*
    211.

    requirement:
    Design a data structure that supports adding new words and finding
    if a string matches any previously added string.
    Implement the WordDictionary class:
        WordDictionary() Initializes the object.
        void addWord(word) Adds word to the data structure, it can be matched later.
        bool search(word) Returns true if there is any string in the data structure
        that matches word or false otherwise. word may contain dots '.'
        where dots can be matched with any letter.
    */
    TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node.children.computeIfAbsent(word.charAt(i), k -> new TrieNode());
            node = node.children.get(word.charAt(i));
        }
        node.completed = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.completed;
        }

        Character character = word.charAt(index);
        if (word.charAt(index) != '.') {
            if (!node.children.containsKey(character)) {
                return false;
            }
            return searchHelper(node.children.get(character), word, index + 1);
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            if (searchHelper(entry.getValue(), word, index + 1)) {
                return true;
            }
        }
        return false;
    }

    public static class TrieNode {
        Map<Character, TrieNode> children;
        boolean completed;
        TrieNode() {
            children = new HashMap<>();
            completed = false;
        }
    }
}
