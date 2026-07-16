class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] chars = new int[26];
            for(char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            String key = Arrays.toString(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
