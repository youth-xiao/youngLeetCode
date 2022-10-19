
class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;
    
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleLinked {
    private Node head;
    private Node tail;
    private int size;
    
    public DoubleLinked() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }
    
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    
    public Node removeFirstNode() {
        if (head.next == tail) { // empty linked list
            return null;
        }
        Node firstNode = head.next;
        remove(firstNode);
        return firstNode;
    }
    
    public int getSize() {
        return size;
    }
}

class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleLinked cache;
    private int cap;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleLinked();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cache.getSize() == cap) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }
    
    private void makeRecently(int key) { // 适用于map里已经存在的节点
        Node x = map.get(key);
        cache.remove(x); // 先把该节点抽取出来
        cache.addLast(x); // 再把该节点放到尾部 越靠尾部 越表示是最近用过的node
    }
    
    private void addRecently(int key, int val) { // 适用于新加的 之前map里没有
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x); // don't forget to add it to the map as well
    }
    
    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(x);
    }
    
    private void removeLeastRecently() {
        Node deletedNode = cache.removeFirstNode();
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */