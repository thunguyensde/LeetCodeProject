public class SingleElementInASortedArray {
    /*
    540.

    */
    public int singleNonDuplicate(int[] nums) {
        // // 0 1 2 3 4 5 6 7 8
        // // 1 1 2 3 3 4 4 5 5

        // l=0, r=8, m=4
        // l=0, r=4, m=2

        // // 0 1 2 3 4 5 6 7 8
        // // 1 1 2 2 3 3 4 5 5

        // l=0, r=8, m=4
        // l=4, r=8, m=6

        // // 0 1 2 3 4 5 6 7 8
        // // 1 2 2 3 3 4 4 5 5

        // l=0, r=8, m=4
        // l=0, r=4, m=2
        // l=0, r=2, m=1
        // l=1, r=2, m=1

        // // 0 1 2
        // // 1 2 2

        // l=0, r=2, m=1

        // // 0 1 2
        // // 1 1 2

        // l=0, r=2, m=1

        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = r + (l - r) / 2;
            if ((m == 0 && m == n - 1) ||
                    (m == 0 && nums[m] != nums[m + 1]) ||
                    (m == n - 1 && nums[m] != nums[m - 1]) ||
                    (nums[m] != nums[m - 1] && nums[m] != nums[m + 1])) {
                return nums[m];
            }
            if (nums[m] != nums[m + 1]) {
                m = m - 1;
            }
            if ((r - m + 1) % 2 == 0) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
