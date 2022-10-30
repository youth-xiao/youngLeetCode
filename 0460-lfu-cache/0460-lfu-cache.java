class LFUCache {
    int capacity;
    int size;
    int min;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLL> countMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DLL lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DLL newList = countMap.getOrDefault(node.count, new DLL());
            newList.add(node);
            countMap.put(node.count, newList);
        }
    }
    
    private void update(Node node) {
        DLL oldList = countMap.get(node.count);
        oldList.remove(node);
        if (node.count == min && oldList.size == 0) {
            min++;
        }
        node.count++;
        DLL newList = countMap.getOrDefault(node.count, new DLL());
        newList.add(node);
        countMap.put(node.count, newList);
    }
    
    
    class Node {
        int key;
        int val;
        int count;
        Node prev;
        Node next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            count = 1;
        }
    }
    
    class DLL {
        Node head;
        Node tail;
        int size;
        
        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }
        
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            } else {
                return null;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */