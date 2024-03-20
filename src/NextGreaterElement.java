import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    /*
    496.

    requirement:
    The next greater element of some element x in an array is the first greater element
    that is to the right of x in the same array.
    You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and
    determine the next greater element of nums2[j] in nums2.
    If there is no next greater element, then the answer for this query is -1.
    Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

    test case:
    1 3 4 2
    3 4 -1 -1

    solution:
    - stack
        + monotonic
        + increasing
    */


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextGreaterElements = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums1[i]) {
                stack.pop();
            }
            nextGreaterElements.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterElements.get(nums1[i]);
        }
        return ans;
    }
}
