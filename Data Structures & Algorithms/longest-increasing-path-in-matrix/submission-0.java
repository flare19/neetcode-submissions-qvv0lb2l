class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
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
        int res = 1 + Math.max(Math.max(dfs(i+1, j, matrix, ROWS, COLS, matrix[i][j]), dfs(i-1, j, matrix, ROWS, COLS, matrix[i][j])),
                Math.max(dfs(i, j+1, matrix, ROWS, COLS, matrix[i][j]), dfs(i, j-1, matrix, ROWS, COLS, matrix[i][j])));
        return res;
    }
}
