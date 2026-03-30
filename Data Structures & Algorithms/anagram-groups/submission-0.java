class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] chars = new int[26];
            for (char c : s.toCharArray()) {
                chars[c - 'a']++;
            }
            String key = Arrays.toString(chars);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
