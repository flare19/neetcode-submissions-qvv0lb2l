class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length + 1][amount + 1];
        for(int i=0; i< coins.length+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(coins, 0, amount);
        return res;
    }
    private int dfs(int[] coins, int i, int remainingAmt) {
        if(remainingAmt == 0) return 1;
        if(remainingAmt < 0 || i >= coins.length) return 0;
        if(dp[i][remainingAmt] != -1) return dp[i][remainingAmt];
        int res = dfs(coins, i, remainingAmt - coins[i]) + dfs(coins, i+1, remainingAmt);
        dp[i][remainingAmt] = res;
        return res;
    }
}
