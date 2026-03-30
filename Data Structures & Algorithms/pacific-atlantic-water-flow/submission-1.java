class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS=heights.length, COLS=heights[0].length;
        Deque<int[]> pac = new LinkedList<>();
        Deque<int[]> atl = new LinkedList<>();
        boolean[][] pacB = new boolean[ROWS][COLS];
        boolean[][] atlB = new boolean[ROWS][COLS];

        for(int c=0; c<COLS; c++){
            pac.add(new int[]{0, c});
            atl.add(new int[]{ROWS-1, c});
        }

        for(int r=0; r<ROWS; r++) {
            pac.add(new int[]{r, 0});
            atl.add(new int[]{r, COLS-1});
        }

        exploreOcean(pac, pacB, heights);
        exploreOcean(atl, atlB, heights);

        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(pacB[r][c] && atlB[r][c]) {
                    res.add(List.of(r,c));
                }
            }
        }
        return res;
    }

    private void exploreOcean(Deque<int[]> q, boolean[][] ocean, int[][] heights ) {
        int ROWS=heights.length, COLS=heights[0].length;
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r=cell[0], c=cell[1];

            if(ocean[r][c]) continue;
            ocean[r][c] = true;

            if(r+1<ROWS && !ocean[r+1][c] && heights[r+1][c] >= heights[r][c]) {
                q.add(new int[]{r+1, c});
            }
            if(r-1>=0 && !ocean[r-1][c] && heights[r-1][c] >= heights[r][c]) {
                q.add(new int[]{r-1, c});
            }
            if(c+1<COLS && !ocean[r][c+1] && heights[r][c+1] >= heights[r][c]) {
                q.add(new int[]{r, c+1});
            }
            if(c-1>=0 && !ocean[r][c-1] && heights[r][c-1] >= heights[r][c]) {
                q.add(new int[]{r, c-1});
            }
        }
    }
}
