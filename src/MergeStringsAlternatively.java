public class MergeStringsAlternatively {
    /*
    1768.

    requirement:
    You are given two strings word1 and word2.
    Merge the strings by adding letters in alternating order,
    starting with word1.
    If a string is longer than the other, append the additional letters onto the end of the merged string.
    Return the merged string.

    test case:
    word1=abc
    word2=123

    */

    public String mergeStrings(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                sb.append(word2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }
}
