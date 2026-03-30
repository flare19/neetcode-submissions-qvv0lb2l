class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i=0; i<text1.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(0, 0, text1, text2);
        return res;
    }
    private int dfs(int i, int j, String text1, String text2) {
        if(i == text1.length() || j == text2.length()) return 0;
        int res = 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            res = 1 + dfs(i+1, j+1, text1, text2);
            dp[i][j] = res;
            return res;
        }
        res = Math.max(dfs(i+1, j, text1, text2), dfs(i, j+1, text1, text2));
        dp[i][j] = res;
        return res;
    }
}
