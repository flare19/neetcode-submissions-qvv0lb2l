class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        q.add(new int[]{grid[0][0], 0, 0});
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[1];
            int c = cell[2];
            int t = cell[0];
            visited[r][c] = true;
            if(r == n-1 && c == n-1) {
                return t;
            }
            if(r+1 < n && visited[r+1][c] == false) {
                q.add(new int[]{Math.max(t, grid[r+1][c]), r+1, c});
            }
            if(r-1 >= 0 && visited[r-1][c] == false) {
                q.add(new int[]{Math.max(t, grid[r-1][c]), r-1, c});
            }
            if(c+1 < n && visited[r][c+1] == false) {
                q.add(new int[]{Math.max(t, grid[r][c+1]), r, c+1});
            }
            if(c-1 >= 0 && visited[r][c-1] == false) {
                q.add(new int[]{Math.max(t, grid[r][c-1]), r, c-1});
            }
        }
        return -1;
    }
}
