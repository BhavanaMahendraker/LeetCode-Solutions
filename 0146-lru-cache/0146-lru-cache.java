class Node{
    int key;
    int val;
    Node prev, next;
    public Node(){
        this.key = -1;
        this.val = -1;
        this.prev = null;
        this.next = null;
    }
    public Node(int key, int value){
        this.key = key;
        this.val = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    
    HashMap<Integer, Node> map;
    int capacity;
    Node head; // Most recent
    Node tail; // Least recent

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void insertNode(Node node){ // always insert in front
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        removeNode(node);
        insertNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            map.remove(key);
        }
        Node new_node = new Node(key, value);
        map.put(key, new_node);
        insertNode(new_node);
        
        if(map.size() > capacity){
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */