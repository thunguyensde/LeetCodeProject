import java.util.TreeMap;

public class HandOfStraights {
    /*
    846.

    */

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        // 1 2 3 2 3 4
        // true

        // 1 2 3 6 7 8
        // true

        // 1 2 3 3 7 8
        // false

        // 1: 1
        // 2: 2
        // 3: 2
        // 4: 1

        // HashMap
        // Traverse map

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for (int card : map.keySet()) {
            int baseCount = map.get(card);

            if (baseCount == 0) {
                continue;
            }

            for (int i = 1; i < groupSize; i++) {
                int count = map.getOrDefault(card + i, 0);
                if (count < baseCount) {
                    return false;
                }
                map.put(card + i, count - baseCount);
            }
        }

        return true;
    }
}
