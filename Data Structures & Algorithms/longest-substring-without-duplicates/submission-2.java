class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> unique = new HashSet<>();
        int l=0, res=0;
        for(int r=0; r<s.length(); r++) {
            while(unique.contains(s.charAt(r))) {
                unique.remove(s.charAt(l));
                l++;
            }
            unique.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
