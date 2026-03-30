class Trie {
    Map<Character, Trie> children = new HashMap<>();
    boolean isEnd = false;
}

class Solution {
    private Trie root;
    public Solution() {
        root = new Trie();
    }
    private void insert(String word) {
        Trie cur = root;
        for(char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Trie());
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }
    public int minExtraChar(String s, String[] dictionary) {
        for(String word : dictionary) {
            insert(word);
        }
        return dfs(0, s);
    }

    private int dfs(int i, String s) {
        if(i >= s.length()) return 0;
        int res = 1 + dfs(i+1, s);

        Trie curr = root;
        for(int j=i; j<s.length(); j++) {
            char c = s.charAt(j);
            Trie next = curr.children.get(c);
            if(next == null) break;

            curr = next;

            if(curr.isEnd) {
                res = Math.min(res, dfs(j+1, s));
            }
        }
        return res;
    }
}