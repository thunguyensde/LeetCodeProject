import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGame7 {
    /*
    1871.

    */

     public boolean canReachWithDp(String s, int minJump, int maxJump) {
         char[] arr = s.toCharArray();
         int n = arr.length;
         // 0 1 2 3 4 5
         // 0 1 1 0 1 0
         boolean[] dp = new boolean[n];
         dp[n - 1] = arr[n - 1] == '0';
         for (int i = n - 2; i >= 0; i--) {
             if (arr[i] != '0') continue;
             for (int j = i + minJump; j <= Math.min(i + maxJump, n - 1); j++) {
                 if (dp[j]) {
                     dp[i] = dp[j];
                     break;
                 }
             }
         }
         return dp[0];
     }

    public boolean canReachWithBfs(String s, int minJump, int maxJump) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // 0 1 2 3 4 5
        // 0 1 1 0 1 0
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int farthest = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i == n - 1) {
                return true;
            }
            for (int j = Math.max(i + minJump, farthest + 1); j <= Math.min(i + maxJump, n - 1); j++) {
                if (arr[j] == '0') {
                    queue.add(j);
                }
            }
            farthest = Math.min(i + maxJump, n - 1);
        }
        return false;
    }
}
