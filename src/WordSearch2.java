import java.util.*;

public class WordSearch2 {
    /*
    212.

    */

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        Set<String> found = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWordsHelper(board, words, i, j, trie.root, found);
            }
        }
        return new ArrayList<>(found);
    }

    private void findWordsHelper(char[][] board, String[] words, int row, int col, TrieNode root, Set<String> found) {
        if (words.length == found.size()) {
            return;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (!root.children.containsKey(board[row][col])) {
            return;
        }
        TrieNode child = root.children.get(board[row][col]);
        if (child.word != null) {
            found.add(child.word);
        }
        char letter = board[row][col];
        board[row][col] = '#';
        findWordsHelper(board, words, row + 1, col, child, found);
        findWordsHelper(board, words, row - 1, col, child, found);
        findWordsHelper(board, words, row, col + 1, child, found);
        findWordsHelper(board, words, row, col - 1, child, found);
        board[row][col] = letter;
    }

    private void optimizedFindWordsHelper(char[][] board, int row, int col, TrieNode root, Set<String> found) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (!root.children.containsKey(board[row][col])) {
            return;
        }
        TrieNode child = root.children.get(board[row][col]);
        if (child.word != null) {
            found.add(child.word);
        }
        char letter = board[row][col];
        board[row][col] = '#';
        optimizedFindWordsHelper(board, row + 1, col, child, found);
        optimizedFindWordsHelper(board, row - 1, col, child, found);
        optimizedFindWordsHelper(board, row, col + 1, child, found);
        optimizedFindWordsHelper(board, row, col - 1, child, found);
        board[row][col] = letter;

        // optimization, remove trienode
        if (child.children.isEmpty()) {
            root.children.remove(letter);
        }
    }


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
            node.word = word;
        }
    }

    public static class TrieNode {
        Map<Character, TrieNode> children;
        String word;

        public TrieNode() {
            this.children = new HashMap<>();
            this.word = null;
        }
    }
}
