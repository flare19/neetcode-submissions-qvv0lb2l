class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] path = new boolean[board.length][board[0].length];
        int r = board.length;
        int c = board[0].length;
        for(int i=0; i<r; i++) {
            for(int k=0; k<c; k++) {
                if(dfs(board, word, i, k, 0, path)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i, boolean[][] path) {
        if(i == word.length()) {
            return true;
        }
        if(r<0 || c<0 || r>= board.length || c>= board[0].length || word.charAt(i) != board[r][c] || path[r][c]) {
            return false;
        }
        path[r][c] = true;
        boolean res = (dfs(board, word, r + 1, c, i + 1, path) ||
        dfs(board, word, r - 1, c, i + 1, path) ||
        dfs(board, word, r, c + 1, i + 1, path) ||
        dfs(board, word, r, c - 1, i + 1, path));
        path[r][c] = false;
        return res;
    }
}
