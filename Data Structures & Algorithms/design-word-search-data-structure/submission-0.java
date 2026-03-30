public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        return dfs(cur, word);
    }

    private boolean dfs(TrieNode cur, String word) {
        if(word.length() == 0) {
            return cur.isEnd;
        }
        char c = word.charAt(0);
        if(c == '.') {
            for(TrieNode child : cur.children.values()) {
                if(dfs(child, word.substring(1))) {
                    return true;
                }
            }
            return false;
        } else {
            if(!cur.children.containsKey(c)) {
                return false;
            }
        }
        return dfs(cur.children.get(c), word.substring(1));
    }
}

