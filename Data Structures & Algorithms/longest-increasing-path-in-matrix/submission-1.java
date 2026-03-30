class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        dp = new int[ROWS + 1][COLS + 1];
        for(int i=0; i<ROWS + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = 0;
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                res = Math.max(dfs(i, j, matrix, ROWS, COLS, -1), res);
            }
        }
        return res;
    }
    private int dfs(int i, int j, int[][] matrix, int ROWS, int COLS, int prev) {
        if(i >= ROWS || i < 0 || j >= COLS || j < 0 || matrix[i][j] <= prev) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int res = 1 + Math.max(Math.max(dfs(i+1, j, matrix, ROWS, COLS, matrix[i][j]), dfs(i-1, j, matrix, ROWS, COLS, matrix[i][j])),
                Math.max(dfs(i, j+1, matrix, ROWS, COLS, matrix[i][j]), dfs(i, j-1, matrix, ROWS, COLS, matrix[i][j])));
        dp[i][j] = res;
        return res;
    }
}
