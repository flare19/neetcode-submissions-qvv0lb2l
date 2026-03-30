class Solution {
    public int minDistance(String word1, String word2) {
        int res = dfs(0, 0, word1, word2);
        return res;
    }
    private int dfs(int i, int j, String word1, String word2) {
        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;
        if(word1.charAt(i) == word2.charAt(j)) {
            int res = dfs(i+1, j+1, word1, word2);
            return res;
        }
        int res = 1 + Math.min(Math.min(dfs(i, j+1, word1, word2), dfs(i+1, j, word1, word2)),
                dfs(i+1, j+1, word1, word2));
        return res;
    }
}
