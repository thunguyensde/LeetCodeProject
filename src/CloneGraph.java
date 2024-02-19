import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    /*
    133.

    requirements:
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
    Node.val is unique for each node.

    test case:
    1 -- 2
    |
    3 -- 4

    1 -- 2
    |    |
    3 -- 4

    solution:
    - dfs
    - visited check
    - map: original node - cloned node
    - add each node
        + if hasn't visited: create it
        + visit neighbors
            + if neighbors hasn't been visited: visit neighbor
            + if neighbors has been visited: add to list

    dry run:

    complexity:
    - time: O(n[vertices] + m[edges])
    - space: O(n)
    */

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return cloneGraphHelper(node, new HashMap<>());
    }

    private Node cloneGraphHelper(Node node, Map<Node, Node> map) {
        if (!map.containsKey(node)) {
            Node cloneNode = new Node(node.val, new ArrayList<>());
            map.put(node, cloneNode);
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraphHelper(neighbor, map));
            }
        }
        return map.get(node);
    }


    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
