class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<obstacleGrid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(0, 0, obstacleGrid, visited);
    }

    public int dfs(int r, int c, int[][] obstacleGrid, boolean[][] visited) {
        int ROWS = obstacleGrid.length, COLS = obstacleGrid[0].length;
        if(r >= ROWS || c >= COLS || r < 0 || c < 0 || visited[r][c] || obstacleGrid[r][c] == 1) {
            return 0;
        }
        if(r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }
        visited[r][c] = true;
        if(dp[r][c] != -1) return dp[r][c];
        int res = dfs(r + 1, c, obstacleGrid, visited) + dfs(r, c+1 ,obstacleGrid, visited);
        dp[r][c] = res;
        visited[r][c] = false;
        return res;
    }
}