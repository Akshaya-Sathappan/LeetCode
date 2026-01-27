class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    ListNode dummy;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        dummy = head;    
    }
    
    public int get(int key) {
        int res = 0;
        if(!map.containsKey(key)){
            return -1;
        }

        else{
            ListNode node = map.get(key);
            res = node.value;
            delete(node);
            insertAfterHead(node);
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.value = value;
            delete(node);
            insertAfterHead(node);
        }

        else{
            if(map.size() == capacity){
                ListNode n = tail.prev;
                map.remove(n.key);
                delete(n);
            }

            ListNode newNode = new ListNode(key, value);

            insertAfterHead(newNode);
            map.put(key, newNode);
        }
    }

    public void delete(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAfterHead(ListNode node){
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;
        dummy.next = node;
    }
}

class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;

    ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */