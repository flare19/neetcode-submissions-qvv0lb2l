public class FreqStack {
    Map<Integer, Integer> map;
    List<Integer> stack;
    public FreqStack() {
        map = new HashMap<>();
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    public int pop() {
        int MaxFreq = 0;
        int MaxElement = 0;
        int MaxIndex = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();
            int index = stack.lastIndexOf(element);
            if(frequency > MaxFreq || frequency == MaxFreq && index > MaxIndex) {
                MaxFreq = frequency;
                MaxElement = element;
                MaxIndex = index;
            }
        }
        stack.remove(MaxIndex);
        if(MaxFreq == 1) {
            map.remove(MaxElement);
        } else {
            map.put(MaxElement, MaxFreq - 1);
        }
        return MaxElement;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */