class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        for(char task : tasks) {
            count.put(task, count.getOrDefault(task,0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : count.values()) {
            maxHeap.offer(num);
        }
        Deque<int[]> q = new ArrayDeque<>();
        int time = 0;
        while(!q.isEmpty() || !maxHeap.isEmpty()) {
            time++;
            if(!q.isEmpty() && q.getFirst()[1] == time) {
                maxHeap.offer(q.removeFirst()[0]);
            }
            if(!maxHeap.isEmpty()) {
                int countOriginal = maxHeap.poll();
                int countUpdated = countOriginal - 1;
                if(countUpdated != 0) {
                    q.add(new int[]{countUpdated, time + n + 1});
                }
            }
        }
        return time;
    }
}
