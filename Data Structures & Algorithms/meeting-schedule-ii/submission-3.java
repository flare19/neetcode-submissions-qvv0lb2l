/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;
        intervals.sort((a, b) -> a.start - b.start);
        int res = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals.get(0).end);
        Interval curr = intervals.get(0);
        int i=1;
        while(!pq.isEmpty() && i < intervals.size()) {
            if(intervals.get(i).start >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals.get(i).end);
            res = Math.max(pq.size(), res);
            i++;
        }
        return res;
    }
}
