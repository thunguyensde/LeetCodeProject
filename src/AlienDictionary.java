import java.util.*;

public class AlienDictionary {
    /*
    269.

    */
    public String alienOrder(String[] words) {
        // case 1:
        // t < f
        // w < e
        // r < t
        // e < r

        //          r -> t -> f
        // w -> e ->
        // output: wertf

        // case 2:
        // w -> e -> r -> w
        // output: ""

        // case 3:
        // w -> e -> f
        //   -> t
        // output: weft or wtef

        // case 4:
        // "ab" "abc"
        // output: abc or bca or cba or ...

        // case 5:
        // "abc" "ab"
        // output: ""

        // Map<Character, Set<Character>>
        // t: [f]
        // w: [e]
        // r: [t]
        // e: [r]
        // -------
        // w: [e]
        // e: [r]
        // r: [w]
        // -------
        // w: [e, t]
        // e: [f]

        // Toposort

        int n = words.length;
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str1 = words[i];
            int l1 = str1.length();

            for (int j = 0; j < l1; j++) {
                graph.put(str1.charAt(j), graph.getOrDefault(str1.charAt(j), new HashSet<>()));
            }

            if (i == n - 1) {
                continue;
            }

            String str2 = words[i + 1];
            int l2 = str2.length();

            for (int j = 0; j < l2; j++) {
                graph.put(str2.charAt(j), graph.getOrDefault(str2.charAt(j), new HashSet<>()));
            }

            if (str1.equals(str2)) {
                continue;
            }

            if (str1.startsWith(str2)) {
                return "";
            }

            if (str2.startsWith(str1)) {
                continue;
            }

            for (int j = 0; j < l1 && j < l2; j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    graph.get(str1.charAt(j)).add(str2.charAt(j));
                    break;
                }
            }
        }

        Map<Character, Integer> inboundDegrees = new HashMap<>();
        for (Map.Entry<Character, Set<Character>> entries : graph.entrySet()) {
            inboundDegrees.put(entries.getKey(), inboundDegrees.getOrDefault(entries.getKey(), 0));
            for (Character ch : entries.getValue()) {
                inboundDegrees.put(ch, inboundDegrees.getOrDefault(ch, 0) + 1);
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for (Character ch : graph.keySet()) {
            if (inboundDegrees.get(ch) == 0) {
                queue.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            sb.append(ch);
            for (Character adjCh : graph.get(ch)) {
                inboundDegrees.put(adjCh, inboundDegrees.get(adjCh) - 1);
                if (inboundDegrees.get(adjCh) == 0) {
                    queue.add(adjCh);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
