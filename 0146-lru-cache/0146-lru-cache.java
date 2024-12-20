import java.util.*;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int k, int v) {
        key = k;
        value = v;
        prev = next = null;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Helper method to add a node right after head
    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper method to remove a node
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // Move the accessed node to the front
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update the value and move node to the front
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            if (map.size() == capacity) {
                // Evict the least recently used node (node before tail)
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            // Add the new node
            Node newNode = new Node(key, value);
            addNode(newNode);
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
