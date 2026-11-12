class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

public class MyCircularQueue {
    ListNode right;
    ListNode left;
    int k;
    public MyCircularQueue(int k) {
        left = new ListNode(0, null, null);
        right = new ListNode(0, null, this.left);
        left.next = right;
        this.k = k;
    }

    public boolean enQueue(int value) {
        if(this.k == 0) return false;
        ListNode curr = new ListNode(value, this.right, this.right.prev);
        this.right.prev.next = curr;
        this.right.prev = curr;
        this.k--;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        ListNode temp = this.left.next.next;
        temp.prev = this.left;
        this.left.next = temp;
        this.k++;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return this.left.next.val;
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return this.right.prev.val;
    }

    public boolean isEmpty() {
        return this.right == this.left.next;
    }

    public boolean isFull() {
        return this.k == 0;
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