public class MyHashMap {
    private Node[] map;
    public MyHashMap() {
        map = new Node[769];
        for(int i=0; i<769; i++) {
            map[i] = new Node();
        }
    }

    private int hash(int key) {
        return key % 769;
    }

    public void put(int key, int value) {
        Node cur = map[hash(key)];
        while(cur.next != null) {
            if(cur.next.key == key) {
                cur.next.value = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new Node(key, value, null);
    }

    public int get(int key) {
        Node cur = map[hash(key)];
        while(cur.next != null) {
            if(cur.next.key == key) {
                return cur.next.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        Node cur = map[hash(key)];
        while(cur.next != null) {
            if(cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}

class Node {
    int value, key;
    Node next;
    public Node(int key, int value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node() {
        this(-1,-1,null);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */