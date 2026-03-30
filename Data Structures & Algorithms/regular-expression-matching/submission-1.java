class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(0, 0, s, p);
    }
    private boolean dfs(int i, int j, String s, String p) {
        if(i >= s.length() && j >= p.length()) return true;
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
            boolean res = dfs(i, j+2, s, p) || (firstMatch && dfs(i+1, j, s, p));
            return res;
        }
        
        if((j < p.length() && i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' )) {
            boolean res = dfs(i+1, j+1, s, p);
            return res;
        }
        return false;
    }
}
