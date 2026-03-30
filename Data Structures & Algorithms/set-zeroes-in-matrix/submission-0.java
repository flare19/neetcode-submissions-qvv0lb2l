class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeroes = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0)
                    zeroes.add(new int[]{i, j});
            }
        }
        for(int[] cell : zeroes) {
            int row = cell[0];
            int col = cell[1];
            Arrays.fill(matrix[row], 0);
            for(int i=0; i<matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
