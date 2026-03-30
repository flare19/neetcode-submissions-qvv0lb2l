class Solution {
    public int maxProfit(int[] prices) {
        int res = dfs(0, false, prices);
        return res;
    }
    private int dfs(int i, boolean holding, int[] prices) {
        if(i >= prices.length) return 0;
        int res = 0;
        if(!holding) {
            res = Math.max(dfs(i+1, false, prices), dfs(i+1, true, prices) - prices[i]);
        }
        if(holding) {
            res = Math.max(dfs(i+1, true, prices), dfs(i+2, false, prices) + prices[i]);
        }
        return res;
    }
}
