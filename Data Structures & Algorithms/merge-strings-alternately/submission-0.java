class Solution {
    public String mergeAlternately(String word1, String word2) {
        int length = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < length; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(word1.length() > word2.length()) {
            String remain = word1.substring(length);
            sb.append(remain);
        } else {
            String remain = word2.substring(length);
            sb.append(remain);
        }
        return sb.toString();
    }
}