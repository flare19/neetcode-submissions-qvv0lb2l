class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i< coins.length+1; i++) {
            dp[i][0] = 1;
        }
        for(int i=coins.length - 1; i>= 0; i--) {
            for(int j=1; j<amount+1; j++) {
                if(j - coins[i] >= 0) {
                    dp[i][j] += dp[i][j - coins[i]] + dp[i+1][j];
                } else {
                    dp[i][j] += dp[i+1][j];
                }
            }
        }
        return dp[0][amount];
    }
}
