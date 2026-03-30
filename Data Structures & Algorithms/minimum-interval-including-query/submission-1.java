

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] queriesSorted = queries.clone();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, Integer> res = new HashMap<>();
        Arrays.sort(queriesSorted);
        int i = 0;
        for(int q : queriesSorted) {
            while(i < intervals.length && intervals[i][0] <= q) {
                pq.offer(new int[]{intervals[i][1], (intervals[i][1] - intervals[i][0] + 1)});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[0] < q) {
                pq.poll();
            }
            res.put(q, pq.isEmpty()? -1 : pq.peek()[1]);
        }
        int[] result = new int[queries.length];
        for(int j=0; j<queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }
}
