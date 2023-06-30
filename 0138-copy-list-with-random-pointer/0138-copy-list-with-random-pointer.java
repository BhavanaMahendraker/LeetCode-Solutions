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
        /*
        // TC = O(N); SC = O(N)
        
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
        */
        
        // TC = O(N); SC = O(1)
        if(head == null) 
            return null;
        Node p1 = head;
        while(p1 != null){
            Node p1_next = p1.next;
            Node copy_node = new Node(p1.val);
            p1.next = copy_node;
            copy_node.next = p1_next;
            p1 = p1_next;
        }
        // Connect random nodes
        p1 = head;
        
        while(p1 != null){
            if(p1.random != null){
                p1.next.random = p1.random.next;
            }
            p1 = p1.next.next;
        }
        
        // Restore next pointers
        p1 = head;
        Node copy_head = head.next;
        
        while(p1 != null){
            Node copy_node = p1.next;
            Node next_node = p1.next.next;
            p1.next = next_node;
            
            if(next_node != null)
                copy_node.next = next_node.next;
            p1 = next_node;
        }
        
        return copy_head;
    }
}