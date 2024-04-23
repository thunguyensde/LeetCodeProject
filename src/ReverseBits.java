public class ReverseBits {
    /*
    190.

    */

    public int reverseBits(int n) {
        int ans = 0;
        int count = 32;
        while (count > 0) {
            ans = (ans << 1) + (n & 1);
            n >>= 1;
            count--;
        }
        return ans;
    }
}
