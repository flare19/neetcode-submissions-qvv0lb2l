class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] costs) {
        dp = new int[costs.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(dfs(costs, 0), dfs(costs, 1));
    }

    private int dfs(int[] costs, int i) {
        if(costs.length <= i) return 0;
        if(dp[i] != -1) return dp[i];
        dp[i] = costs[i] + Math.min(dfs(costs, i+1), dfs(costs, i+2));
        return dp[i];
    }
}
