/*
// Definition for a Node.
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
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node node, HashMap<Node, Node> oldToNewMap){
        if(node == null){
            return null;
        }

        if(oldToNewMap.containsKey(node)){
            return oldToNewMap.get(node);
        }

        Node clone = new Node(node.val);
        oldToNewMap.put(node, clone);

        for(Node neigh: node.neighbors){
            clone.neighbors.add(dfs(neigh, oldToNewMap));
        }

        return clone;
    }
}