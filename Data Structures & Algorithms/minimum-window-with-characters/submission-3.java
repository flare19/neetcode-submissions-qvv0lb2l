class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }
        if(t.isEmpty()) {
            return "";
        }
        int l=0, minStart=0, reslen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int required = map.size();
        for(int r=0; r<s.length(); r++) {
            if(map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                if(map.get(s.charAt(r)) == 0) {
                    required--;
                }
                if(required == 0) {
                    if(r-l+1 < reslen) {
                        reslen = r-l+1;
                        minStart = l;
                    }
                    while(required == 0) {
                        if(r-l+1 < reslen) {
                            reslen = r-l+1;
                            minStart = l;
                        }
                        char leftChar = s.charAt(l);
                        if(map.containsKey(leftChar)) {
                            if(map.get(leftChar) == 0) {
                                required++;
                            }
                            map.put(leftChar, map.get(leftChar) + 1);
                        }
                        l++;
                    }
                }
            }
        }
        return reslen == Integer.MAX_VALUE? "" : s.substring(minStart, minStart + reslen);
    }
}
