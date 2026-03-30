class Solution {
    public int countSubstrings(String s) {
        int o = 0, e = 0;
        for(int i=0; i<s.length(); i++) {
            o += dfs(s, i, i);
            e += dfs(s, i, i+1);
        }
        return o + e;
    }
    private int dfs(String s, int l, int r) {
        if(l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        return 1 + dfs(s, l-1, r+1);
    }
}
