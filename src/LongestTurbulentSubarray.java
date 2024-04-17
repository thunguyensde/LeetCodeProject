public class LongestTurbulentSubarray {
    /*
    978.

    requirement:
    Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
    A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
    More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
    For i <= k < j:
        arr[k] > arr[k + 1] when k is odd, and
        arr[k] < arr[k + 1] when k is even.
    Or, for i <= k < j:
        arr[k] > arr[k + 1] when k is even, and
        arr[k] < arr[k + 1] when k is odd.

    test case:
    1 3 2 5 4 --> /\/\
    0 1 3 2 5 4 0 --> 5
    9 1 3 2 5 4 9 --> 7 \/\/\/
    0 1 3 2 5 4 9 --> 6 /\/\/

    5 3 4 1 2 --> \/\/
    */
    public int betterMaximumTurbulentSubarray(int[] arr) {
        int n = arr.length;
        int currentSubarray = 1;
        int maxSubarray = 1;
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && Integer.compare(arr[i], arr[i + 1]) * Integer.compare(arr[i - 1], arr[i]) < 0) {
                currentSubarray++;
            } else if (arr[i] != arr[i + 1]) {
                currentSubarray = 2;
            } else {
                currentSubarray = 1;
            }
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        return maxSubarray;
    }

    public int maximumTurbulentSubarray(int[] arr) {
        int n = arr.length;

        boolean allNumberAreEqual = true;
        for (int num : arr) {
            if (num != arr[0]) {
                allNumberAreEqual = false;
                break;
            }
        }
        if (allNumberAreEqual) {
            return 1;
        }

        int currentSubarray = 2;
        int maxSubarray = 2;
        for (int i = 1; i < n - 1; i++) {
            if ((arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) ||
                    (arr[i] < arr[i + 1] && arr[i] < arr[i - 1])) {
                currentSubarray++;
            } else {
                currentSubarray = 2;
            }
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        return maxSubarray;
    }
}
