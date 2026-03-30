class Solution {
    public int getSum(int a, int b) {
        int res = 0;
        int carry = 0;
        for(int i=0; i<32; i++) {
            int bit1 = (a >> i) & 1, bit2 = (b >> i) & 1;
            int sum = bit1 ^ bit2 ^ carry;
            carry = (bit1 + bit2 + carry) >= 2? 1 : 0;
            if(sum != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
