class Solution {
    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int res = dfs(n, 0);
        return res;
    }
    private int dfs(int n, int i) {
        if(i >= n) return i == n? 1 : 0;
        if(dp[i] != -1) return dp[i];
        dp[i] = dfs(n, i+1) + dfs(n, i+2);
        return dp[i];
    }
}
