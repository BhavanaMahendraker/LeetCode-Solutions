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
        Node p1 = head;
        
        // Create map with copy nodes
        while(p1 != null){
            mapToCopy.put(p1, new Node(p1.val));
            p1 = p1.next;
        }
        
        // Connect the nodes
        p1 = head;
        
        while(p1 != null){
            mapToCopy.get(p1).next = mapToCopy.get(p1.next);
            mapToCopy.get(p1).random = mapToCopy.get(p1.random);
            p1 = p1.next;
        }
        
        return mapToCopy.get(head);
    }
}