class ListNodeLFU {
    int key, val, freq;
    ListNodeLFU prev, next;

    ListNodeLFU(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DoublyLinkedList {
    private ListNodeLFU left, right;
    private int size;

    DoublyLinkedList() {
        this.left = new ListNodeLFU(0, 0);
        this.right = new ListNodeLFU(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.size = 0;
    }

    public int length() {
        return size;
    }

    public void pushRight(ListNodeLFU node) {
        ListNodeLFU prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
        size++;
    }

    public void pop(ListNodeLFU node) {
        ListNodeLFU prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    public ListNodeLFU popLeft() {
        ListNodeLFU node = this.left.next;
        pop(node);
        return node;
    }

    public void update(ListNodeLFU node) {
        pop(node);
        pushRight(node);
    }
}

public class LFUCache {
    int capacity;
    int lfuCnt;
    Map<Integer, ListNodeLFU> valMap;
    Map<Integer, DoublyLinkedList> listMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCnt = 0;
        this.valMap = new HashMap<>();
        this.listMap = new HashMap<>();
    }

    public void counter(ListNodeLFU node) {
        int count = node.freq;
        listMap.get(count).pop(node);

        if(count == lfuCnt && listMap.get(count).length() == 0) {
            lfuCnt++;
        }
        node.freq++;
        listMap.putIfAbsent(node.freq, new DoublyLinkedList());
        listMap.get(node.freq).pushRight(node);
    }

    public int get(int key) {
        if(!valMap.containsKey(key)) {
            return -1;
        }
        ListNodeLFU node = valMap.get(key);
        counter(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }

        if(valMap.containsKey(key)) {
            ListNodeLFU node = valMap.get(key);
            node.val = value;
            counter(node);
            return;
        }

        if(valMap.size() == capacity) {
            ListNodeLFU toRemove = listMap.get(lfuCnt).popLeft();
            valMap.remove(toRemove.key);
        }

        ListNodeLFU node = new ListNodeLFU(key, value);
        valMap.put(key, node);
        listMap.putIfAbsent(1, new DoublyLinkedList());
        listMap.get(1).pushRight(node);
        lfuCnt = 1;
    }
}
