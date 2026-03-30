class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int left = 0, right = ROWS * COLS - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / COLS, col = mid % COLS;
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
