import java.util.Set;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    /*
    1456.

    */

    public int maxVowels(String s, int k) {
        int curNumVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                curNumVowels++;
            }
        }

        int n = s.length();
        int maxNumVowels = curNumVowels;
        for (int i = 1; i <= n - k; i++) {
            if (isVowel(s.charAt(i - 1))) {
                curNumVowels--;
            }
            if (isVowel(s.charAt(i + k - 1))) {
                curNumVowels++;
            }
            maxNumVowels = Math.max(maxNumVowels, curNumVowels);
        }

        return maxNumVowels;
    }

    private boolean isVowel(char ch) {
        return Set.of ('a', 'e', 'i', 'o', 'u').contains(ch);
    }
}
