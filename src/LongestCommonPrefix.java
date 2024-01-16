public class LongestCommonPrefix {
    /*
    14.

    requirement:
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    test case:
    car, card --> car
    car --> car
    car, card, barn, barney --> ""
    "", "" --> ""

    solution:
    - traverse every string
    - each string, traverse every character
    --> nope
    - traverse every character of every string

    dry run:

    complexity:
    - time: O(n * m)
    - space: O(1)
    */
    public String findLongestCommonPrefixString(String[] strs) {
        int n = strs.length;

        if (n == 0) return "";

        int m = strs[0].length();
        for (String string : strs) {
            m = Math.min(m, string.length());
        }

        int i = 0;
        for (; i < m; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, i);
    }
}
