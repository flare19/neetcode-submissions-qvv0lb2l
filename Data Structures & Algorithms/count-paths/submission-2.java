class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ROWS = m, COLS = n;
        int paths = dfs(0, 0, ROWS, COLS);
        return paths;
    }
    private int dfs(int r, int c, int ROWS, int COLS) {
        if(r >= ROWS || r < 0 || c >= COLS || c < 0) return 0;
        int paths = 0;
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        if(r == ROWS - 1 && c == COLS - 1) {
            paths += 1;
            return paths;
        }
        paths = dfs(r+1, c, ROWS, COLS) + dfs(r, c+1, ROWS, COLS);
        dp[r][c] = paths;
        return paths;
    }
}
