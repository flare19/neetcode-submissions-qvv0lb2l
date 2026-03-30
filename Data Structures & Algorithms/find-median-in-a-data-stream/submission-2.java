class MedianFinder {
PriorityQueue<Integer> smallMaxHeap;
PriorityQueue<Integer> largeMinHeap;

    public MedianFinder() {
        smallMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallMaxHeap.offer(num);
        if(!smallMaxHeap.isEmpty() && !largeMinHeap.isEmpty() && smallMaxHeap.peek() > largeMinHeap.peek()) {
            largeMinHeap.add(smallMaxHeap.poll());
        }
        if(smallMaxHeap.size() > largeMinHeap.size() + 1) {
            largeMinHeap.add(smallMaxHeap.poll());            
        } 
        if(smallMaxHeap.size() + 1 < largeMinHeap.size()) {
            smallMaxHeap.add(largeMinHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(smallMaxHeap.size() > largeMinHeap.size()) {
            return (double) smallMaxHeap.peek();
        }
        if(largeMinHeap.size() > smallMaxHeap.size()) {
            return (double) largeMinHeap.peek();
        }

        return (double)(largeMinHeap.peek() + smallMaxHeap.peek()) / 2;
    }
}
