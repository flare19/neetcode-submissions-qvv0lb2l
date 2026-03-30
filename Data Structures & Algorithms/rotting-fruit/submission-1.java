class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
                if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        int time=0;
        while(!q.isEmpty() && fresh>0) {
            int size = q.size();
            time++;
            for(int i=0; i<size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                if(iHateThisQuestion(r+1, c, ROWS, COLS, grid, q)) fresh--;
                if(iHateThisQuestion(r-1, c, ROWS, COLS, grid, q)) fresh--;
                if(iHateThisQuestion(r, c+1, ROWS, COLS, grid, q)) fresh--;
                if(iHateThisQuestion(r, c-1, ROWS, COLS, grid, q)) fresh--;
            }
        }
        return fresh==0? time : -1;
    }

    private boolean iHateThisQuestion(int r, int c, int ROWS, int COLS, int[][] grid, Deque<int[]> q) {
        if(r<0 || c<0 || r>=ROWS || c>=COLS || grid[r][c] == 2 || grid[r][c] == 0) {
            return false;
        }
        grid[r][c] = 2;
        q.add(new int[]{r,c});
        return true;
    }
}
