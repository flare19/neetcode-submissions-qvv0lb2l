class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0);
    }
    private int dfs(String s, int i) {
        if(i >= s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int res = dfs(s, i+1);
        if(s.charAt(i) == '1' && i+1<s.length() ||
                s.charAt(i) == '2' && i+1 < s.length() && "0123456".contains(String.valueOf(s.charAt(i+1)))) {
            res += dfs(s, i+2);
        }
        dp[i] = res;
        return res;
    }
}
