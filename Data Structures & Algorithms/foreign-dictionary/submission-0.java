class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Integer> in = new HashMap<>();
        Map<Character, Set<Character>> wordMap = new HashMap<>();
        for(int i=0; i<words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.startsWith(word2) && word2.length() < word1.length()) {
                return "";
            }
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) == word2.charAt(j)) continue;
                //different letter is seen condition here
                if (word1.charAt(j) != word2.charAt(j)) {
                    wordMap.computeIfAbsent(word1.charAt(j), k -> new HashSet<>()).add(word2.charAt(j));
                    break;
                }
            }
        }

        wordMap.forEach((key, value) -> {
            for(char c : value) {
                in.put(c, in.getOrDefault(c, 0) + 1);
            }
        });
        for(String word : words) {
            for(char c : word.toCharArray()) {
                wordMap.putIfAbsent(c, new HashSet<>());
                in.putIfAbsent(c, 0);
            }
        }
        //map construction complete and in degree map also complete
        Queue<Character> q = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        in.forEach((key, value) -> {
            if(value == 0) q.add(key);
        });
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            visited.add(c);
            res.append(c);
            Set<Character> values = wordMap.get(c);
            for(char value : values) {
                if(!visited.contains(value)) {
                    in.put(value, in.get(value) - 1);
                    if(in.get(value) == 0) q.add(value);
                }
            }
        }
        if(res.length() == wordMap.size()) return res.toString();
        return "";
    }
}
