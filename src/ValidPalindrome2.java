public class ValidPalindrome2 {
    /*
    680.

    requirement:
    Given a string s, return true if the s can be palindrome after deleting at most one character from it.

    test case:
    - abcba -> true
    - abcdba -> true
    - a -> true
    - ab -> true
    - abcda -> false

    solution:
    - 2 pointers
    - 2 passes

    dry run:

    complexity:
    - time: O(n)
    - space: O(1)
    */

    public boolean isPalindromeAfterDeletingAtMostOneCharacter(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        return i >= j || isPalindromeHelper(s, i, j + 1) || isPalindromeHelper(s, i + 1, j);
    }

    private boolean isPalindromeHelper(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }
}
