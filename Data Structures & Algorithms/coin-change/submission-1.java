class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        for(int i=0; i<coins.length+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(coins, 0, amount);
        return res >= 900000? -1 : res;
    }
    private int dfs(int[] coins, int i, int amount) {
        if(amount < 0 || i >= coins.length) return 1000000;
        if(amount == 0) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int res = Math.min(Math.abs(1 + dfs(coins, i, amount - coins[i])),
                Math.abs(dfs(coins, i+1, amount)));
        dp[i][amount] = res;
        return res;
    }
}
