class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dfs(n);
    }
    private int dfs(int n) {
        if(n <= 0) return 0;
        if(dp[n] != -1) return dp[n];
        int res = 1;
        for(int j=1; j <= n-1; j++) {
            res = Math.max(res, (j * Math.max((n-j), dfs(n-j))));
        }
        dp[n] = res;
        return res;
    }
}