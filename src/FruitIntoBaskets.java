import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    /*
    904.

    */

    public int totalFruit(int[] fruits) {
        // 1 1 2 2 1 3
        int n = fruits.length;
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxFruits = 0;
        while (right < n) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                int count = map.get(fruits[left]);
                if (count == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], count - 1);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        return maxFruits;
    }
}
