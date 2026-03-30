class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int res=0;
        int[] curr = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            if(curr[1] > intervals[i][0]) {
                curr = intervals[i][1] < curr[1]? intervals[i] : curr;
                res++;
            } else {
                curr = intervals[i][1] > curr[1]? intervals[i] : curr;
            }
        }
        return res;
    }
}
