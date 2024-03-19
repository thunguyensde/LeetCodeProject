import java.util.Arrays;

public class CanPlaceFlowers {
    /*
    605.

    requirement:
    You have a long flowerbed in which some of the plots are planted, and some are not.
    However, flowers cannot be planted in adjacent plots.
    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
    return true if n new flowers can be planted in the flowerbed
    without violating the no-adjacent-flowers rule and false otherwise.

    test case:
    1 0 1
    0 0 1
    1 0 0 1
    1 0 0 0 1

    solution:
    count available plots
    0 0 1
    */

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] flowerbedAfter = Arrays.copyOf(flowerbed, flowerbed.length);
        int availableSpot = 0;
        for (int i = 0; i < flowerbedAfter.length; i++) {
            if (flowerbedAfter[i] == 1) {
                continue;
            }
            if ((i == 0 || flowerbedAfter[i - 1] == 0) && (i == flowerbedAfter.length - 1 || flowerbedAfter[i + 1] == 0)) {
                flowerbedAfter[i] = 1;
                availableSpot++;
            }
        }
        return availableSpot >= n;
    }
}
