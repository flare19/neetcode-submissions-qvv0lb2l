class NumMatrix {
    int[][] PreMatrix;
    public NumMatrix(int[][] matrix) {
        PreMatrix = new int[matrix.length+1][matrix[0].length+1];
        Arrays.fill(PreMatrix[0], 0);
        for(int i=0; i<matrix.length+1; i++) {
            PreMatrix[i][0] = 0;
        }
        for(int i=0; i< matrix.length; i++) {
            int prefix = 0;
            for(int j=0; j<matrix[0].length; j++){
                prefix += matrix[i][j];
                int colSum = PreMatrix[i][j+1];
                PreMatrix[i+1][j+1] = prefix + colSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 = row1+1;
        row2 = row2+1;
        col1 = col1+1;
        col2 = col2+1;

        int bottomRight = PreMatrix[row2][col2];
        int top = PreMatrix[row1 - 1][col2];
        int left = PreMatrix[row2][col1 - 1];
        int topLeft = PreMatrix[row1 - 1][col1 - 1];
        return bottomRight - top - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */