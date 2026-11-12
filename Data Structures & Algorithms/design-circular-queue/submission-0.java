class MyCircularQueue {

    LinkedList<Integer> queue;
    int k;
    public MyCircularQueue(int k) {
        queue = new LinkedList<>();
        this.k = k;
    }

    public boolean enQueue(int value) {
        if(queue.size() == k) {
            return false;
        }
        queue.add(value);
        return true;
    }

    public boolean deQueue() {
        if(queue.isEmpty()) {
            return false;
        }
        queue.removeFirst();
        return true;
    }

    public int Front() {
        if(queue.isEmpty()) return -1;
        return queue.getFirst();
    }

    public int Rear() {
        if(queue.isEmpty()) return -1;
        return queue.getLast();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */