public class JumpGame {
    /*
    55.

    */

     public boolean canJumpWithDynamicProgramming(int[] nums) {
         int n = nums.length;
         boolean[] dp = new boolean[n];
         dp[n - 1] = true;
         for (int i = n - 2; i >= 0; i--) {
             int step = 1;
             while (step <= nums[i] && !dp[i] && i + step < n) {
                 dp[i] = dp[i + step];
                 step++;
             }
         }
         return dp[0];
     }

    public boolean canJumpWithGreedy(int[] nums) {
        int n = nums.length;
        int safePos = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= safePos) {
                safePos = i;
            }
        }
        return safePos == 0;
    }

    public boolean myCanJumpWithBfs(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n - 1) {
            if (left > right) return false;
            int farthest = right; // 3
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1; // 4
            right = farthest; // 3
        }
        return true;
    }
}
