public class LengthOfLastWord {
    /*
    58.

    requirement:
    Given a string s consisting of words and spaces, return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.

    test case:
    "  nguyen   anh thu   "
    */

    public int lengthOfLastWord(String s) {
        s = s.trim();

        int length = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
