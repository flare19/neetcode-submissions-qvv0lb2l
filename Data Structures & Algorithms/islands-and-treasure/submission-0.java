class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> q = new LinkedList<>();
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                }
            }
        }
        while(!q.isEmpty()) {
            for(int i=0; i<q.size(); i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                int d = grid[r][c];
                addRoom(r+1, c, ROWS, COLS, grid, q, d);
                addRoom(r-1, c, ROWS, COLS, grid, q, d);
                addRoom(r, c+1, ROWS, COLS, grid, q, d);
                addRoom(r, c-1, ROWS, COLS, grid, q, d);
            }
        }
    }

    private void addRoom(int r, int c, int ROWS, int COLS, int[][] grid, Deque<int[]> q, int d) {
        if(r<0 || c<0 || r>=ROWS || c>= COLS || grid[r][c] == -1) {
            return;
        }
        if(grid[r][c] == Integer.MAX_VALUE) {
            q.add(new int[]{r, c});
            grid[r][c] = d + 1;
        }
    }
}
