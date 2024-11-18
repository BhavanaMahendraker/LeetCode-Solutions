/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mapToCopy = new HashMap<>();
        Node p = head;
        
        while(p != null){
            mapToCopy.put(p, new Node(p.val));
            p = p.next;
        }
        
        for(Node node: mapToCopy.keySet()){
            mapToCopy.get(node).next = mapToCopy.get(node.next);
            mapToCopy.get(node).random = mapToCopy.get(node.random);
        }
        
        return mapToCopy.get(head);
    }
}