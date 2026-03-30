class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(s, part, res, 0);
        return res;
    }

    private void dfs(String s, List<String> part, List<List<String>> res, int i) {
        if(i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if(palindrome(s, i, j)) {
                part.add(s.substring(i, j+1));
                dfs(s, part, res, j+1);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean palindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
