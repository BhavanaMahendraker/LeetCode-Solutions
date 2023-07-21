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
        return cloneHelper(node, new HashMap<>());
    }
    
    public Node cloneHelper(Node node, HashMap<Node, Node> mapOldToNew){
        if(node == null)
            return node;
        if(mapOldToNew.containsKey(node))
            return mapOldToNew.get(node);
        
        Node copyNode = new Node(node.val);
        mapOldToNew.put(node, copyNode);
        for(Node neigh: node.neighbors){
            copyNode.neighbors.add(cloneHelper(neigh, mapOldToNew));
        }
        return copyNode;
    }
}