public class GreatestCommonDivisorOfStrings {
    /*
    1071.
    */
    public int greatestCommonDivisorOfTwoNumbers(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return greatestCommonDivisorOfTwoNumbers(num2, num1 % num2);
    }

    public String myAttemptGreatestCommonDivisorOfTwoStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return myAttemptGreatestCommonDivisorOfTwoStrings(str2, str1);
        }

        if (str2.isEmpty()) {
            return str1;
        }

        String remainder = getRemainder(str1, str2);
        if (remainder.equals(str1)) {
            return "";
        }

        return myAttemptGreatestCommonDivisorOfTwoStrings(str2, remainder);
    }

    private String getRemainder(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        for (int i = 0; i < n; i += m) {
            for (int j = 0; j < m; j++) {
                if (i + j >= n || str1.charAt(i + j) != str2.charAt(j)) {
                    return str1.substring(i);
                }
            }
        }
        return "";
    }

    public String smarterGreatestCommonDivisorOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, greatestCommonDivisorOfTwoNumbers(str1.length(), str2.length()));
    }
}
