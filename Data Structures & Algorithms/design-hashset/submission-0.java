public class MyHashSet {
    LinkedList<Integer>[] buckets;
    public MyHashSet() {
        buckets = new LinkedList[1000];
        for(int i=0; i<1000; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        if(buckets[key % 1000].contains(key)) {
            return;
        }
        buckets[key % 1000].add(key);
    }

    public void remove(int key) {
        buckets[key % 1000].remove((Integer) key);
    }

    public boolean contains(int key) {
        return buckets[key % 1000].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */