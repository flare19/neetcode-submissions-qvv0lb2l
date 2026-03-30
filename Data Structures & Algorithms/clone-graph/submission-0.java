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
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> tracker = new HashMap<>();
        tracker.put(node, new Node(node.val));
        q.add(node);
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(Node n : cur.neighbors) {
                if(!tracker.containsKey(n)) {
                    tracker.put(n, new Node(n.val));
                    q.add(n);
                }
                tracker.get(cur).neighbors.add(tracker.get(n));
            }
        }
        return tracker.get(node);
    }
}