class Solution {
    public int minimumEffortPath(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        Set<List<Integer>> visited = new HashSet<>();
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            int r = pair[0], c = pair[1];
            int dist = pair[2];
            if(visited.contains(Arrays.asList(r, c))) continue;
            if(r == ROWS - 1 && c == COLS - 1) {
                return dist;
            }
            visited.add(Arrays.asList(r, c));
            if(r+1 < ROWS && !visited.contains(Arrays.asList(r+1, c)))
                pq.offer(new int[]{r+1, c, Math.max(dist, Math.abs(heights[r][c] - heights[r+1][c]))});
            if(r-1 >= 0 && !visited.contains(Arrays.asList(r-1, c)))
                pq.offer(new int[]{r-1, c, Math.max(dist, Math.abs(heights[r][c] - heights[r-1][c]))});
            if(c+1 < COLS && !visited.contains(Arrays.asList(r, c+1)))
                pq.offer(new int[]{r, c+1, Math.max(dist, Math.abs(heights[r][c] - heights[r][c+1]))});
            if(c-1 >= 0 && !visited.contains(Arrays.asList(r, c-1)))
                pq.offer(new int[]{r, c-1, Math.max(dist, Math.abs(heights[r][c] - heights[r][c-1]))});
        }
        return 0;
    }
}