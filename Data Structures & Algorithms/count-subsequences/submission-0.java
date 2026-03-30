class Solution {
    public int numDistinct(String s, String t) {
        int res = dfs(0, 0, s, t);
        return res;
    }
    private int dfs(int i, int j, String s, String t) {
        if(j >= t.length() && i <= s.length()) return 1;
        if(i >= s.length() && j < t.length()) return 0;
        int res = 0;
        if(s.charAt(i) == t.charAt(j)) {
            res = dfs(i+1, j+1, s, t) + dfs(i+1, j, s, t);
            return res;
        }
        res = dfs(i+1, j, s, t);
        return res;
    }
}
