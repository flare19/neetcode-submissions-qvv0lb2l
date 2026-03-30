class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones) {
            maxHeap.offer(num);
        }
        while(maxHeap.size() != 1) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();
            maxHeap.offer(Math.abs(s1-s2));
        }
        return maxHeap.peek();
    }
}
