class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i < n+1; i++) {
            int limit = (int) Math.floor(Math.sqrt(i));
            int res = Integer.MAX_VALUE;
            for(int j=1; j<=limit; j++) {
                res = Math.min(1 + dp[i - (j*j)], res);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}