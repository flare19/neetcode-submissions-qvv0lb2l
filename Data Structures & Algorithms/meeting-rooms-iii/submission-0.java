class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] count = new int[n];
        PriorityQueue<Integer> freePQ = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            freePQ.offer(i);
        }
        PriorityQueue<int[]> busyPQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int[] meeting : meetings) {
            pq.offer(meeting);
        }
        while(!pq.isEmpty()) {
            int[] meeting = pq.poll();
            while(!busyPQ.isEmpty() && busyPQ.peek()[0] <= meeting[0] ) {
                int[] freed = busyPQ.poll();
                freePQ.offer(freed[1]);
            }
            if(!freePQ.isEmpty()) {
                int room = freePQ.poll();
                busyPQ.offer(new int[] {meeting[1], room});
                count[room]++;
            } else {
                int[] latest = busyPQ.poll();
                if(latest[0] > meeting[0]) {
                    int diff = latest[0] - meeting[0];
                    busyPQ.add(new int[] {diff + meeting[1], latest[1]});
                    count[latest[1]]++;
                    continue;
                }
                busyPQ.add(new int[] {meeting[1], latest[1]});
                count[latest[1]]++;
            }
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            if(count[i] > count[res]) {
                res = i;
            }
        }

        return res;
    }
}