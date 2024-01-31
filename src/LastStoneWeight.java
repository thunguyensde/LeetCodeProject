import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {
    /*
    1046.

    requirement:
    You are given an array of integers stones where stones[i] is the weight of the ith stone.
    We are playing a game with the stones.
    On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y.
    The result of this smash is:
    If x == y, both stones are destroyed, and
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
    At the end of the game, there is at most one stone left.
    Return the weight of the last remaining stone. If there are no stones left, return 0.

    test case:
    5 5 3 2 1 --> 0

    solution:
    - sorting
    - heap

    dry run:

    complexity:
    - time: O(nlogn)
    - space: O(n)
    */

    public int getWeightOfLastRemainingStone(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();
            if (x != y) {
                heap.add(y - x);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }
}
