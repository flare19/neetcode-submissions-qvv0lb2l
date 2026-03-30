class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0; i<9; i++) {
            Set<Character> rows = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    continue;
                } else {
                    if (rows.contains(board[i][j])) {
                        return false;
                    } else {
                        rows.add(board[i][j]);
                    }
                }
            }
        }
        for(int i=0; i<9; i++) {
            Set<Character> cols = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[j][i] == '.') {
                    continue;
                } else {
                    if (cols.contains(board[j][i])) {
                        return false;
                    } else {
                        cols.add(board[j][i]);
                    }
                }
            }
        }
        for(int squares=0; squares < 9; squares++) {
            Set<Character> boxes = new HashSet<>();
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    int row = (squares / 3 ) * 3 + i;
                    int col = (squares % 3 ) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(boxes.contains(board[row][col])) return false;
                    boxes.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
