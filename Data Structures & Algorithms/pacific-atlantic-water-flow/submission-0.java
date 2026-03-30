class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        Set<List<Integer>> p = new HashSet<>();
        Set<List<Integer>> a = new HashSet<>();

        for(int c=0; c<COLS; c++) {
            dfs(0, c, p, ROWS, COLS, heights[0][c], heights);
            dfs(ROWS-1, c, a, ROWS, COLS, heights[ROWS-1][c], heights);
        }
        for(int r=0; r<ROWS; r++){
            dfs(r, 0, p, ROWS, COLS, heights[r][0], heights);
            dfs(r, COLS-1, a, ROWS, COLS, heights[r][COLS-1], heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(p.contains(List.of(r, c)) && a.contains(List.of(r, c))) {
                    res.add(List.of(r,c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, Set<List<Integer>> visited, int ROWS, int COLS, int prevH, int[][] heights) {
        if(r<0 || c<0 || r>=ROWS || c>=COLS || visited.contains(List.of(r, c)) || heights[r][c] < prevH) {
            return;
        }
        visited.add(List.of(r, c));
        dfs(r+1, c, visited, ROWS, COLS, heights[r][c], heights);
        dfs(r-1, c, visited, ROWS, COLS, heights[r][c], heights);
        dfs(r, c+1, visited, ROWS, COLS, heights[r][c], heights);
        dfs(r, c-1, visited, ROWS, COLS, heights[r][c], heights);
    }
}
