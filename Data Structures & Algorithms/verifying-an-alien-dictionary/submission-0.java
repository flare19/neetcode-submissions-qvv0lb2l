class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for(int i=0; i<26; i++) {
            rank[order.charAt(i) - 'a'] = i;
        }
        int i = 0;
        while(i+1 < words.length) {
            String word1 = words[i], word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());
            boolean diff = false;
            for(int j=0; j<len; j++) {
                if(rank[word2.charAt(j) - 'a'] - rank[word1.charAt(j) - 'a'] < 0) {
                    return false;
                } else if(rank[word2.charAt(j) - 'a'] - rank[word1.charAt(j) - 'a'] > 0) {
                    diff = true;
                    break;
                } else {
                    continue;
                }
            }
            if(!diff && word1.length() > word2.length()) return false;
            i++;
        }
        return true;
    }
}