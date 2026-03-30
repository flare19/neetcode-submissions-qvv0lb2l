class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        boolean[][] path = new boolean[board.length][board[0].length];
        for(String s : words) {
            for(int r=0; r<board.length; r++) {
                for(int c=0; c<board[0].length; c++) {
                    if(dfs(board, s, r, c, 0, path)) {
                        res.add(s);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i, boolean[][] path) {
        if(i == word.length()) {
            return true;
        }
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || word.charAt(i) != board[r][c] || path[r][c]) {
            return false;
        }
        path[r][c] = true;
        boolean res = dfs(board, word, r+1, c, i+1, path) || dfs(board, word, r-1, c, i+1, path) || dfs(board, word, r, c+1, i+1, path) || dfs(board, word, r, c-1, i+1, path);
        path[r][c] = false;
        return res;
    }
}
