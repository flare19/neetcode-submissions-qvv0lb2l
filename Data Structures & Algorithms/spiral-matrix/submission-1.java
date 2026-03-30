class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int l=0, r=matrix[0].length-1, top=0, bottom=matrix.length-1;
        while(l <= r && top <= bottom) {
            if(bottom >= top) {
                for(int i=l; i<=r; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            }
            if(r >= l) {
                for(int i=top; i<=bottom; i++) {
                    res.add(matrix[i][r]);
                }
                r--;
            }
            if(bottom >= top) {
                for(int i=r; i>=l; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(l <= r) {
                for(int i=bottom; i>l; i--) {
                    res.add(matrix[i][l]);
                }
                l++;
            }
        }
        return res;
    }
}
