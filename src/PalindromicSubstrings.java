public class PalindromicSubstrings {
    /*
    647.

    requirement:
    - Given a string s, return the number of palindromic substrings in it.
    - A string is a palindrome when it reads the same backward as forward.
    - A substring is a contiguous sequence of characters within the string.

    test case:
    aba123aba --> 11

    single center
    longest length = 9
    --> the number of sub-palindrome length = 9 + 1 / 2
    abcdedcba

    abcdeedcba
    longest length = 10
    --> the number of sub-palindrome length = 10 / 2

    solution:
    - onion algorithm
    - detect the longest palindrome at a given center
        + single center
        + double center
    */

    public int countPalindromeSubstring(String s) {
        int countPalindrome = 0;
        for (int i = 0; i < s.length(); i++) {
            int lengthOfLongestSingleCenterPalindrome = getLengthOfLongestPalindromicSubstring(s, i, i);
            countPalindrome += (lengthOfLongestSingleCenterPalindrome + 1) / 2;

            int lengthOfLongestDoubleCenterPalindrome = getLengthOfLongestPalindromicSubstring(s, i, i + 1);
            countPalindrome += lengthOfLongestDoubleCenterPalindrome / 2;
        }

        return countPalindrome;
    }

    private int getLengthOfLongestPalindromicSubstring(String s, int leftCenter, int rightCenter) {
        int i = leftCenter;
        int j = rightCenter;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
