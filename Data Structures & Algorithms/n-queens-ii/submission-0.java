class Solution {
    Set<Integer> col;
    Set<Integer> pos;
    Set<Integer> neg;
    public int totalNQueens(int n) {
        col = new HashSet<>();
        pos = new HashSet<>();
        neg = new HashSet<>();
        return dfs(0, n);
    }

    private int dfs(int r, int n) {
        int res = 0;
        if(r == n) {
            return 1;
        }
        for(int c=0; c<n; c++) {
            if(col.contains(c) || pos.contains(r + c) || neg.contains(r - c)) continue;
            
            col.add(c);
            pos.add(r + c);
            neg.add(r - c);
            
            res += dfs(r+1, n);
            
            col.remove(c);
            pos.remove(r + c);
            neg.remove(r - c);
        }
        return res;
    }
}