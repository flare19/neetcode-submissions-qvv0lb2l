class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length+1][3];
        for(int i=0; i<prices.length+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(0, false, prices);
        return res;
    }
    private int dfs(int i, boolean holding, int[] prices) {
        if(i >= prices.length) return 0;
        int res = 0;
        if(!holding) {
            if(dp[i][0] != -1) return dp[i][0];
            res = Math.max(dfs(i+1, false, prices), dfs(i+1, true, prices) - prices[i]);
            dp[i][0] = res;
        }
        if(holding) {
            if(dp[i][1] != -1) return dp[i][1];
            res = Math.max(dfs(i+1, true, prices), dfs(i+2, false, prices) + prices[i]);
            dp[i][1] = res;
        }
        return res;
    }
}
