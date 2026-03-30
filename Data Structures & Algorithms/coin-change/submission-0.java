class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, 0, amount);
        return res >= 900000? -1 : res;
    }
    private int dfs(int[] coins, int i, int amount) {
        if(amount < 0 || i >= coins.length) return 1000000;
        if(amount == 0) return 0;
        int res = Math.min(Math.abs(1 + dfs(coins, i, amount - coins[i])),
                Math.abs(dfs(coins, i+1, amount)));
        return res;
    }
}
