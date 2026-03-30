class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];
        for(int i=0; i< prices.length+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, false, prices);
    }

    private int dfs(int i, boolean holding, int[] prices) {
        if(i >= prices.length) return 0;
        int max = 0;
        if(holding) {
            if(dp[i][1] != -1) return dp[i][1];
            max = Math.max(dfs(i+1, false, prices) + prices[i], dfs(i+1, true, prices));
        }
        if(!holding) {
            if(dp[i][0] != -1) return dp[i][0];
            max = Math.max(dfs(i+1, true, prices) - prices[i], dfs(i+1, false, prices));
        }
        dp[i][holding? 1 : 0] = max;
        return max;
    }
}