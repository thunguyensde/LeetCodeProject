public class FindTheDifference {
    /*
    389.

    */

    public char findTheDifference(String s, String t) {
        char xor = t.charAt(0);
        for (int i = 1; i < t.length(); i++) {
            xor ^= t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            xor ^= s.charAt(i);
        }

        return xor;
    }
}
