import java.util.*;

public class TaskScheduler {
    /*
    621.

    */

    public int leastInterval(char[] tasks, int n) {
        // count frequency
        // 0 -> n - 1, put task in, start with most to least frequent tasks

        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());

        int idles = 0;
        while (!heap.isEmpty()) {
            int i = 0;
            int cycle = n + 1;
            Set<Character> usedTask = new HashSet<>();
            while (!heap.isEmpty() && i < cycle) {
                Character task = heap.poll();
                if (map.get(task) > 1) {
                    map.put(task, map.get(task) - 1);
                    usedTask.add(task);
                }
                i++;
            }

            heap.addAll(usedTask);

            if (heap.isEmpty()) {
                return idles + tasks.length;
            }

            idles += (cycle - i);
        }

        return idles + tasks.length;
    }
}
