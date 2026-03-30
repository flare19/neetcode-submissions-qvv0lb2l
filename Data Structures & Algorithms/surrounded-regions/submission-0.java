class Solution {
    public void solve(char[][] board) {
        int ROWS=board.length, COLS=board[0].length;
        Deque<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        
        for(int c=0; c<COLS; c++) {
            if(board[0][c] == 'O') q.add(new int[]{0, c});
            if(board[ROWS-1][c] == 'O') q.add(new int[]{ROWS-1, c});
        }
        for(int r=0; r<ROWS; r++) {
            if(board[r][0] == 'O') q.add(new int[]{r, 0});
            if(board[r][COLS-1] == 'O') q.add(new int[]{r, COLS-1});
        }

        bfs(q, board, visited);

        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(board[r][c] == 'O' && !visited[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void bfs(Deque<int[]> q, char[][] board, boolean[][] visited) {
        int ROWS=board.length, COLS=board[0].length;
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r=cell[0], c=cell[1];
            if(visited[r][c]) continue;
            visited[r][c] = true;
            if(r+1<ROWS && board[r+1][c] == 'O') {
                q.add(new int[]{r+1, c});
            }
            if(r-1>=0 && board[r-1][c] == 'O') {
                q.add(new int[]{r-1, c});
            }
            if(c+1<COLS && board[r][c+1] == 'O') {
                q.add(new int[]{r, c+1});
            }
            if(c-1>=0 && board[r][c-1] == 'O') {
                q.add(new int[]{r, c-1});
            }
        }
    }
}
