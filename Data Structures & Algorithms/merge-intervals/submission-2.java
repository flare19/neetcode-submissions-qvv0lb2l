class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return new int[][]{intervals[0]};
        Arrays.sort(intervals, (a,b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            if(cmp != 0) return cmp;
            return Integer.compare(a[1], b[1]);
        });
        List<int[]> res = new ArrayList<>();
        int[] current = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            if(current[1] >= intervals[i][0]) {
                current = new int[]{Math.min(current[0], intervals[i][0]), Math.max(current[1], intervals[i][1])};
                continue;
            }
            res.add(current);
            current = intervals[i];
        }
        res.add(current);
        return res.toArray(new int[res.size()][]);
    }
}
