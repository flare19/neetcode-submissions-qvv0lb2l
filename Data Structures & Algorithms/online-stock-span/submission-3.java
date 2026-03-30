class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        if(stack.isEmpty()) {
            stack.push(new int[]{price, 1});
            return 1;
        }
        if(stack.peek()[0] <= price) {
            while(!stack.isEmpty() && stack.peek()[0] <= price) {
                count += stack.peek()[1];
                stack.pop();
            }
            stack.add(new int[]{price, count});
        }
        if(stack.peek()[0] > price) {
            stack.add(new int[]{price, 1});
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */