class MyStack {
    Deque<Integer> q1;
    Deque<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
        while(!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        Deque<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
    }

    public int pop() {
        return q2.poll();
    }

    public int top() {
        return q2.peek();
    }

    public boolean empty() {
        return q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */