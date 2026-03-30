class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        dp = new int[2][piles.length+1][piles.length+1];
        for(int i=0; i<2; i++) {
            for(int j=0; j<piles.length+1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(true, 0, 1, piles);
    }

    private int dfs(boolean isAlex, int i, int M, int[] piles) {
        if(i >= piles.length) {
            return 0;
        }
        
        if(dp[isAlex? 1 : 0][i][M] != -1) return dp[isAlex? 1 : 0][i][M];
        
        int res = isAlex? 0 : Integer.MAX_VALUE;
        int total = 0;
        for(int X=1; X <= M * 2; X++) {
            if(i + X > piles.length) break;
            total += piles[i + X - 1];
            if(isAlex) {
                res = Math.max(res, total + dfs(false, i + X, Math.max(M, X), piles));
            } else {
                res = Math.min(res, dfs(true, i + X, Math.max(M, X), piles));
            }
        }
        dp[isAlex? 1 : 0][i][M] = res;
        return res;
    }
}