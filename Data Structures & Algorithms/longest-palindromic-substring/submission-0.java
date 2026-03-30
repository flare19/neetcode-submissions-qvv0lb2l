class Solution {
    public String longestPalindrome(String s) {
        StringBuilder e = new StringBuilder();
        StringBuilder o = new StringBuilder();
        String res = "";
        for(int i=0; i<s.length(); i++) {
            e.setLength(0);
            o.setLength(0);
            dfs(s, i, i, o);
            dfs(s, i, i+1, e);
            res = res.length() > Math.max(e.length(), o.length()) ? res :
                    e.length() > o.length() ? e.toString() : o.toString();
        }
        return res;
    }
    private void dfs(String s, int l, int r, StringBuilder res) {
        if(l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) {
            return;
        }
        if(l == r) {
            res.append(s.charAt(l));
        } else {
            res.insert(0, s.charAt(l));
            res.append(s.charAt(r));
        }
        dfs(s, l-1, r+1, res);
    }
}
