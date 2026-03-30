class Solution {
    public int reverse(int x) {
        int res = 0, max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        while(Math.abs(x) > 0) {
            int digit = x % 10;
            x = x / 10;
            if(Math.abs(res) > max / 10 ) {
                return 0;
            }
            if(Math.abs(res) == max / 10) {
                if(digit > max % 10) return 0; 
            }
            res = (res * 10) + digit;
        }
        return res;
    }
}
