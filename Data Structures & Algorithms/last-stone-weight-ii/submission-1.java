class Solution {
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int S = 0;
        for(int stone: stones) {
            S += stone;
        }
        dp = new int[stones.length + 1][S+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, stones, S);
    }

    public int dfs(int i, int currSum, int[] stones, int S) {
        if(i == stones.length) {
            return Math.abs(S - 2 * currSum);
        }
        if(dp[i][currSum] != -1) return dp[i][currSum];
        int w = stones[i];
        dp[i][currSum] = Math.min(dfs(i+1, currSum + w, stones, S), dfs(i+1, currSum, stones, S));
        return Math.min(dfs(i+1, currSum + w, stones, S), dfs(i+1, currSum, stones, S));
    }
}