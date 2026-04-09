/*
Definition for a Node.
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
*/

class Solution {
    private Node clone (Node node, HashMap<Node, Node> visited) {
        if (node == null || visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone_node = new Node(node.val);
        visited.put(node, clone_node);
        for (Node ele : node.neighbors) {
            clone_node.neighbors.add(clone(ele, visited));
        }
        return clone_node;
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        return clone(node, new HashMap<>());
    }
}