public class NumberOf1Bits {
    /*
    191.

    requirement:
    Write a function that takes the binary representation of a positive integer and
    returns the number of set bits it has (also known as the Hamming weight).

    test case:
    101 --> 2
    */

    // 00000...101
    // 00000...001
    public int countNumberOf1Bits(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    // 101
    // 100
    // 100

    // 100
    // 011
    // 000
    public int betterCountNumberOf1Bits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
