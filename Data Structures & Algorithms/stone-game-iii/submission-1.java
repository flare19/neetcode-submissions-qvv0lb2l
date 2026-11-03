class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        dp = new int[stoneValue.length];
        Arrays.fill(dp, -1);
        int res = dfs(0, stoneValue);
        if(res > 0) {
            return "Alice";
        } else if(res < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public int dfs(int i, int[] stones) {
        if(i >= stones.length) {
            return 0;
        }
        int sum = 0;
        int total = Integer.MIN_VALUE;
        if(dp[i] != -1) return dp[i];
        for(int k=i; k<Math.min(i+3, stones.length); k++) {
            sum += stones[k];
            total = Math.max(total, sum - dfs(k+1, stones));
        }
        dp[i] = total;
        return total;
    }
}