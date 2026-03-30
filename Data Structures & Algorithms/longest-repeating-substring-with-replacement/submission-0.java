class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, res=0;
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()) {
            count.putIfAbsent(c, 0);
        }
        for(int r=0; r<s.length(); r++) {
            count.merge(s.charAt(r), 1, Integer::sum);
            while((r-l+1) - (Collections.max(count.values())) > k) {
                count.merge(s.charAt(l), 1, (oldValue, newValue) -> oldValue-1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
