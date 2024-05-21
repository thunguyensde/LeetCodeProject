import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    /*
    1838.

    */

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = 0;
        long sum = 0;
        int max = 0;

        // 3 6 9
        while (right < n) {
            sum += nums[right]; // 15
            while ((long)nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }
            right++; // 2
            max = Math.max(max, right - left); // 1
        }

        return max;
    }
}
