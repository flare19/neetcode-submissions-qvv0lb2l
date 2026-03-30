class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, Math.max(map.getOrDefault(c, 0), i));
        }
        List<Integer> res = new ArrayList<>();
        int end = 0, start = 0;
        for(int i=0; i<s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if(end == i) {
                res.add((end - start) + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
