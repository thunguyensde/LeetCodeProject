public class VerifyingAnAlienDictionary {
    /*
    953.

    requirement:
    In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
    The order of the alphabet is some permutation of lowercase letters.
    Given a sequence of words written in the alien language, and the order of the alphabet,
    return true if and only if the given words are sorted lexicographically in this alien language.

    test case:
    order=bca
    words=["ba","bc"] -> false
    words=["bca","ba"} -> true
    words=["bc", "bca"] -> true
    words=["bca", "bc"] -> false
    words=["bc", "c"]

    solution:
    map = new int[26]
    1.
    check 1st letter of every word
    check 2nc letter of every word
    ...
    2.
    check word[0] < word[1]
    check word[1] < word[2]
    ...

    dry run:

    complexity:
    - time: O(n) with n = total characters combined
    - space: O(1)

    optimization:

    */
    public boolean isSortedInAlienLanguage(String[] words, String order) {
        int[] orderArray = new int[26];
        for (int i = 0; i < 26; i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }

        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            if (compareAlienWords(words[i], words[i + 1], orderArray) == 1) {
                return false;
            }
        }
        return true;
    }

    public int compareAlienWords(String word1, String word2, int[] orderArray) {
        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            if (orderArray[word1.charAt(i) - 'a'] < orderArray[word2.charAt(i) - 'a']) {
                return -1;
            } else if (orderArray[word1.charAt(i) - 'a'] > orderArray[word2.charAt(i) - 'a']) {
                return 1;
            }
        }
        return Integer.compare(word1.length(), word2.length());
    }
}
