class Solution {
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(0, s, wordDict);
    }
    private boolean dfs(int i, String s, List<String> wordDict) {
        if(i >= s.length()) return true;
        if(dp[i] != -1) return dp[i] == 1;
        for(int j=i+1; j<=s.length(); j++) {
            if(wordDict.contains(s.substring(i,j))) {
                if(dfs(j, s, wordDict)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = 0;
        return false;
    }
}
