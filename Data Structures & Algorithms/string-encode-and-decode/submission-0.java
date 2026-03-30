class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s : strs) {
            encoded.append(s.length()).append("#").append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = j + 1 + len;
            decoded.add(str.substring(i, j));
            i = j;
        }
        return decoded;
    }
}
