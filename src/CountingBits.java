public class CountingBits {
    /*
    338.

    */

    public int[] countBits_1(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            if (x % 2 == 0) {
                ans[x] = ans[x / 2];
            } else {
                ans[x] = ans[x - 1] + 1;
            }
        }

        return ans;
    }

    public int[] countBits_2(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            if ((x & 1) == 0) {
                ans[x] = ans[x >> 1];
            } else {
                ans[x] = ans[x - 1] + 1;
            }
        }

        return ans;
    }

    public int[] countBits_3(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            ans[x] = ans[x >> 1] + (x & 1);
        }

        return ans;
    }

    public int[] countBits_4(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            ans[x] = ans[x & (x - 1)] + 1;
        }

        return ans;
    }
}
