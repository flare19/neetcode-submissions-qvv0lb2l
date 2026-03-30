class Solution {
    int paths;
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        boolean[][] grid = new boolean[m][n];
        paths = 0;
        dfs(0, 0, grid);
        return paths;
    }
    private void dfs(int r, int c, boolean[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        if(r >= ROWS || r < 0 || c >= COLS || c < 0 || grid[r][c]) return;
        if(dp[r][c] == 1) {
            paths++;
            return;
        }
        if(r == ROWS - 1 && c == COLS - 1) {
            paths += 1;
            return;
        }
        dp[r][c] = 1;
        grid[r][c] = true;
        dfs(r+1, c, grid);
        dfs(r, c+1, grid);
        grid[r][c] = false;
        dp[r][c] = 0;
    }
}
