public class LongestPalindromicSubstring {
    /*
    5.

    requirement:
    Given a string s, return the longest palindromic substring in s.

    test case:
    012345678
    abcdedcef --> 5

    solution:
    - onion algo
    - get the longest substring with each and every positible centers at ith

    complexity:
    - time: O(n^2)
    - space: O(1)
    */

    public String getLongestPalindromicSubstring(String s) {
        int[] boundOfLongestSubstring = new int[2];
        int longestLength = 1;
        for (int i = 0; i < s.length(); i++) {
            int[] boundOfSingleCenter = getLongestPalindromicSubstringHelper(s, i, i);
            int lengthOfSingleCenter = boundOfSingleCenter[1] - boundOfSingleCenter[0] + 1;
            if (lengthOfSingleCenter > longestLength) {
                boundOfLongestSubstring = boundOfSingleCenter;
                longestLength = lengthOfSingleCenter;
            }

            int[] boundOfDoubleCenter = getLongestPalindromicSubstringHelper(s, i, i + 1);
            int lengthOfDoubleCenter = boundOfDoubleCenter[1] - boundOfDoubleCenter[0] + 1;
            if (lengthOfDoubleCenter > longestLength) {
                boundOfLongestSubstring = boundOfDoubleCenter;
                longestLength = lengthOfDoubleCenter;
            }
        }
        return s.substring(boundOfLongestSubstring[0], boundOfLongestSubstring[1] + 1);
    }

    private int[] getLongestPalindromicSubstringHelper(String s, int leftCenter, int rightCenter) {
        int i = leftCenter;
        int j = rightCenter;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return new int[]{i + 1, j - 1};
    }
}
