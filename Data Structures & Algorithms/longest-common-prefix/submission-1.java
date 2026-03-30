class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String ref = strs[0];
        for(int i=0; i<ref.length(); i++) {
            char c = ref.charAt(i);
            for(String str : strs) {
                if(i >= str.length() || str.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return ref;
    }
}