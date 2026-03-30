class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                res.addAll(Arrays.asList(intervals).subList(i, intervals.length));
                return res.toArray(new int[res.size()][]);
            } else if(intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } else {
                newInterval = new int[] {Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
