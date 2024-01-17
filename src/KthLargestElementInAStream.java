import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    /*
    703.

    requirement:
    Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
    not the kth distinct element.
    Implement KthLargest class:
    - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
    - int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

    test case:
    - k = 3
    - nums = [6 3 1 4 9 5]
    - add(2) -> 3
    - add(0) -> 2

    solution:
    - heap
    - max heap of size k

    dry run:

    complexity:
    - time: O(nlogk)
    - space: O(k)
    */

    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
    }

    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
