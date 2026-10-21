public class FreqStack {
    Map<Integer, Integer> count;
    int maxCnt;
    Map<Integer, Stack<Integer>> stacks;
    public FreqStack() {
        count = new HashMap<>();
        maxCnt = 0;
        stacks = new HashMap<>();
    }

    public void push(int val) {
        int valueCount = count.getOrDefault(val, 0) + 1;
        count.put(val, valueCount);
        if(valueCount > maxCnt) {
            maxCnt = valueCount;
            stacks.putIfAbsent(valueCount, new Stack<>());
        }
        stacks.get(valueCount).push(val);
    }

    public int pop() {
        int res = stacks.get(maxCnt).pop();
        count.put(res, count.get(res) - 1);
        if(stacks.get(maxCnt).isEmpty()) {
            maxCnt--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */