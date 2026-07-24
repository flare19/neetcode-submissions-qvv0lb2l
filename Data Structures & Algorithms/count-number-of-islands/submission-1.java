class Solution {
    public int numIslands(char[][] grid) {
        int res =0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(dfs(grid, i, j, visited) != 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public int dfs(char[][] grid, int r, int c, boolean[][] visited) {
        int ROWS=grid.length, COLS=grid[0].length;
        if(r >= ROWS || c >= COLS || r < 0 || c < 0) {
            return 0;
        }
        if(grid[r][c] == '0') {
            return 0;
        }
        if(visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        dfs(grid, r+1,c,visited);
        dfs(grid, r-1,c,visited);
        dfs(grid, r,c+1,visited);
        dfs(grid, r,c-1,visited);
        return 1;
    }
}
