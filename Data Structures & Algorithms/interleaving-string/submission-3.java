class Solution {
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0; i < s1.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        if((s1.length() + s2.length()) != s3.length()) return false;
        return dfs(0, 0, s1, s2, s3);
    }
    private boolean dfs(int i, int j, String s1, String s2, String s3) {
        if(i >= s1.length() && j >= s2.length()) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            dp[i][j] = 1;
            if(dfs(i+1, j, s1, s2, s3)) return true;
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            dp[i][j] = 1;
            if(dfs(i, j + 1, s1, s2, s3)) return true;
        }
        dp[i][j] = 0;
        return false;
    }
}
