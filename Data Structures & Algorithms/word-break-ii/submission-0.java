public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEnd;
    }

    boolean startsWith(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word : wordDict) {
            trie.insert(word);
        }
        TrieNode root = trie.root;
        return dfs(s, 0, root);
    }

    public List<String> dfs(String s, int i, TrieNode root) {
        if(i == s.length()) {
            return List.of("");
        }
        List<String> res = new ArrayList<>();
        TrieNode curr = root;
        for(int j=i; j<s.length(); j++) {
            char c = s.charAt(j);
            if(!curr.children.containsKey(c)) break;
            curr = curr.children.get(c);
            if(curr.isEnd) {
                String w = s.substring(i, j+1);
                List<String> rest = dfs(s, j+1, root);
                for(String words : rest) {
                    if(words.isEmpty()) {
                        res.add(w);
                    } else {
                        res.add(w + " " + words);
                    }
                }
            }
        }
        return res;
    }
}