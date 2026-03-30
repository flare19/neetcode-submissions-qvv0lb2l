class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(s.length() == 1) return s.charAt(0) == '0'? 0: 1;
        int two = 1, one = 0, outofboundscharacterfornow = 0;
        for(int i=s.length()-1; i>=0;i--) {
            if(s.charAt(i) == '0') {
                one = 0;
            } else {
                one = two;
                if(i+1 < s.length() && s.charAt(i) == '1' ||
                i+1 < s.length() && s.charAt(i) == '2' && s.charAt(i+1) < '7') {
                    one += outofboundscharacterfornow;
                }
            }
            outofboundscharacterfornow = two;
            two = one;
            one = 0;
        }
        return two;
    }
}
