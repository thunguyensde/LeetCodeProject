public class ReplaceElementsWithGreatestElementOnRightSide {
    /*
    1299.

    Given an array arr, replace every element in that array with the greatest element among the elements to its right,
    and replace the last element with -1.
    After doing so, return the array.

    test case:
    9 1 5 4 3
    */

    public int[] replaceElementWithGreatestElementOnRightSide(int[] arr) {
        int n = arr.length;
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            arr[i] = max;
            max = Math.max(max, num);
        }
        return arr;
    }
}
