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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty()) return true;
        intervals.sort((a, b) -> a.start - b.start);
        Interval curr = intervals.getFirst();
        for(int i=1; i<intervals.size(); i++) {
            if(curr.end > intervals.get(i).start) {
                return false;
            }
            curr = intervals.get(i);
        }
        return true;
    }
}
