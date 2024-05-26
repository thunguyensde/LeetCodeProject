public class ShuffleTheArray {
    /*
    1470.

    */

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        for (int i = 0, j = 0; j < n; j++, i += 2){
            ans[i] = nums[j];
            ans[i + 1] = nums[j + n];
        }
        // 0 1 2 3 4 5
        // 2 3
        return ans;
    }
}
