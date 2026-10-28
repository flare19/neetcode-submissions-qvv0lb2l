class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, grid);
    }

    public int dfs(int r, int c, int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        if(r >= ROWS || c >= COLS || r < 0 || c < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if(r == ROWS - 1 && c == COLS - 1) {
            return grid[r][c];
        }
        if(dp[r][c] != -1) return dp[r][c];
        int res = Math.min(grid[r][c] + dfs(r+1, c, grid), grid[r][c] + dfs(r, c+1, grid));
        dp[r][c] = res;
        return res;
    }
}