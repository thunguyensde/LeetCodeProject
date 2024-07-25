import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    /*
    494.

    */
    public int findTargetSumWays(int[] nums, int target) {
        // [1 1 1] & target=2
        // +1 +1 +1 --> no
        // +1 +1 -1 --> no
        // +1 -1 +1 --> no
        // +1 -1 -1 --> no
        // -1 +1 +1

        // the number of ways to get
        // - to target & at index=n-1

        // = sum of the number of ways to get
        // - to target - nums[n - 1] & at index=n-2
        // - to target + nums[n - 1] & at index=n-2

        // dp[i][j]: the number of ways to get to target=i, at index=j
        // dp[0][0] (base case) = nums[0] == 0 ? 1 : 0
        // dp[0][1] =
        // dp[i][j] = dp[i-nums[i - 1]][j - 1] + dp[i-nums[i - 1]][]

        int n = nums.length;
        Map<String, Integer> memo = new HashMap<>();
        return findTargetSumWaysHelper(nums, n - 1, target, memo);
    }

    private int findTargetSumWaysHelper(int[] nums, int index, int target, Map<String, Integer> memo) {
        if (index == -1) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        String key = index + "-" + target;
        if (!memo.containsKey(key)) {
            int value = findTargetSumWaysHelper(nums, index - 1, target - nums[index], memo) +
                    findTargetSumWaysHelper(nums, index - 1, target + nums[index], memo);
            memo.put(key, value);
        }
        return memo.get(key);
    }
}
