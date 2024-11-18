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
        if(head == null) return null;
        Node currNode = head;
        
        // Creating new nodes
        while(currNode != null){
            Node newNode = new Node(currNode.val);
            Node next = currNode.next;
            currNode.next = newNode;
            newNode.next = next;
            currNode = next;
        }
        
        // Setting random
        currNode = head;
        while(currNode != null){
            if(currNode.random != null){
                currNode.next.random = currNode.random.next;
            }
            currNode = currNode.next.next;
        }
        
        // Separating new Nodes from original
        currNode = head;
        Node newHead = head.next;
        while(currNode != null){
            Node nextNode = currNode.next.next;
            currNode.next.next = nextNode == null ? null : nextNode.next;
            currNode.next = nextNode;
            currNode = nextNode;
        }
        
        return newHead;
        
        
        
        
//         HashMap<Node, Node> mapToCopy = new HashMap<>();
//         Node p = head;
        
//         while(p != null){
//             mapToCopy.put(p, new Node(p.val));
//             p = p.next;
//         }
        
//         for(Node node: mapToCopy.keySet()){
//             mapToCopy.get(node).next = mapToCopy.get(node.next);
//             mapToCopy.get(node).random = mapToCopy.get(node.random);
//         }
        
//         return mapToCopy.get(head);
    }
}

/*
[7,null],[13,0],[11,4],[10,2],[1,0]
                                    p
 
[7,null],[13,null],[11,nul],[10,null][1,null]
 
next = p.next
p.next = newNode
newNode.next = next



*/