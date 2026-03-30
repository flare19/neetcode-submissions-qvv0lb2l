class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for(int i=0; i<s.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(0, 0, s, t);
        return res;
    }
    private int dfs(int i, int j, String s, String t) {
        if(j >= t.length() && i <= s.length()) return 1;
        if(i >= s.length() && j < t.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int res = 0;
        if(s.charAt(i) == t.charAt(j)) {
            res = dfs(i+1, j+1, s, t) + dfs(i+1, j, s, t);
            dp[i][j] = res;
            return res;
        }
        res = dfs(i+1, j, s, t);
        dp[i][j] = res;
        return res;
    }
}
