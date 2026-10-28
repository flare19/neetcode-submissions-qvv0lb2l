class Solution {
    vector<vector<int>> dp;
public:
    int minPathSum(vector<vector<int>> grid) {
        dp.resize(grid.size(), vector<int>(grid[0].size(), -1));
        return dfs(0, 0, grid);
    }

    int dfs(int r, int c, vector<vector<int>>& grid) {
        int ROWS = grid.size(), COLS = grid[0].size();
        if (r >= ROWS || c >= COLS || c < 0 || r < 0) {
            return INT_MAX / 2;
        }
        if (r == ROWS - 1 && c == COLS - 1) {
            return grid[r][c];
        }
        if (dp[r][c] != -1) return dp[r][c];
        int res = min(grid[r][c] + dfs(r+1, c, grid), grid[r][c] + dfs(r, c+1, grid));
        dp[r][c] = res;
        return res;
    }
};