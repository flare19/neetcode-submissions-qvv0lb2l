class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dfs(n);
    }

    private int dfs(int target) {
        if(target == 0) return 0;
        if(target < 0) return Integer.MAX_VALUE;
        if(dp[target] != -1) return dp[target];
        int limit = (int) Math.floor(Math.sqrt(target));
        int res = Integer.MAX_VALUE;
        for(int i=1; i<=limit; i++) {
            res = Math.min(1 + dfs(target - (i*i)), res);
        }
        dp[target] = res;
        return res;
    }
}