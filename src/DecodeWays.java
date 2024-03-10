import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    /*
    91.

    requirement:
    A message containing letters from A-Z can be encoded into numbers using the following mapping:
    'A' -> "1"
    'B' -> "2"
    ...
    'Z' -> "26"
    To decode an encoded message,
    all the digits must be grouped then mapped back into letters using the reverse of the mapping above
    (there may be multiple ways). For example, "11106" can be mapped into:
    "AAJF" with the grouping (1 1 10 6)
    "KJF" with the grouping (11 10 6)
    Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

    Given a string s containing only digits, return the number of ways to decode it.
    The test cases are generated so that the answer fits in a 32-bit integer.

    test case:
    - 11106
    - 11
        -AA
        -K
    - 33
        -C
    solution:
    - call dp[i] is the number of ways to decode string s from [0, i - 1]
    - dp[i] = dp[i - 1] + dp[i - 2]
        + condition:
            substring[i - 1, i] needs to be valid
            substring[i - 2, i] needs to be valid
    - dp[0] = 0
    - dp[1] = 1
    - find dp[n]

    dry run

    complexity:
    - time: O(n)
    - space: O(n)
    */
    //061

    public int numberOfDecodingWays(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = isValidDigit(s.substring(0, 1)) ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = isValidDigit(s.substring(i - 1, i))
                    ? dp[i] + dp[i - 1]
                    : dp[i]; // 1
            dp[i] = isValidDigit(s.substring(i - 2, i))
                    ? dp[i] + dp[i - 2]
                    : dp[i]; // 1
        }
        return dp[n];
    }

    private boolean isValidDigit(String substr) {
        return !substr.startsWith("0") &&
                Integer.parseInt(substr) >= 1 &&
                Integer.parseInt(substr) <= 26;
    }

    public static void main(String[] args) {
        new DecodeWays().numberOfDecodingWays("11");
    }
}
