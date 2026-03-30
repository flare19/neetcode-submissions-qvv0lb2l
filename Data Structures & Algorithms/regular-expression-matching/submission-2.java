class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        for(int i=s.length(); i>=0; i--) {
            for(int j=p.length()-1; j>=0; j--) {
                boolean firstMatch =(j < p.length() && i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
                if(j+1 < p.length() && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                    continue;
                }
                if(firstMatch) {
                    dp[i][j] = dp[i+1][j+1];
                    continue;
                }
                dp[i][j] = false;
            }
        }
        return dp[0][0];
    }
}
