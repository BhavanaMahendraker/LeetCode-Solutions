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
        HashMap<Node, Node> mapNodes = new HashMap<>();
        return dfsCloneGraph(node, mapNodes);
    }
    
    private Node dfsCloneGraph(Node node, HashMap<Node, Node> mapNodes){
        if(node == null)
            return null;
        
        if(mapNodes.containsKey(node)){
            return mapNodes.get(node);
        }
        
        Node clone = new Node(node.val);
        mapNodes.put(node, clone);
        
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(dfsCloneGraph(neighbor, mapNodes));
        }
        
        return clone;
    }
    
}