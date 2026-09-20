class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        int[] count = new int[n];
        PriorityQueue<Integer> freePQ = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            freePQ.offer(i);
        }
        PriorityQueue<long[]> busyPQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        for(int[] meeting : meetings) {
            pq.offer(new long[] {
                    (long) meeting[0], (long) meeting[1]
            });
        }
        while(!pq.isEmpty()) {
            long[] meeting = pq.poll();
            while(!busyPQ.isEmpty() && busyPQ.peek()[0] <= meeting[0] ) {
                long[] freed = busyPQ.poll();
                freePQ.offer((int) freed[1]);
            }
            if(!freePQ.isEmpty()) {
                int room = freePQ.poll();
                busyPQ.offer(new long[] {meeting[1], room});
                count[room]++;
            } else {
                long[] latest = busyPQ.poll();
                if(latest[0] > meeting[0]) {
                    long diff = latest[0] - meeting[0];
                    busyPQ.add(new long[] {diff + meeting[1], latest[1]});
                    count[(int) latest[1]]++;
                    continue;
                }
                busyPQ.add(new long[] {meeting[1], latest[1]});
                count[(int) latest[1]]++;
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