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
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        
        while(p != null){
            map.put(p, new Node(p.val));
            p = p.next;
        }
        
        for(Node node: map.keySet()){
            Node nextNode = node.next;
            map.get(node).next = map.get(nextNode);
            
            Node randomNode = node.random;
            map.get(node).random = map.get(randomNode);
        }
        
        return map.get(head);
    }
}