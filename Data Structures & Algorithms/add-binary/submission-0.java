class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i=a.length() - 1, j=b.length() - 1;
        while(i>=0 || j>= 0 || carry > 0) {
            int bit1 = i>=0 ? a.charAt(i) - '0' : 0;
            int bit2 = j>=0 ? b.charAt(j) - '0' : 0;

            int total = bit1 + bit2 + carry;
            res.append(total % 2);
            carry = total / 2;

            j--;
            i--;
        }
        return res.reverse().toString();
    }
}