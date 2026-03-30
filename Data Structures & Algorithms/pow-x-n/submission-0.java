class Solution {
    public double myPow(double x, int n) {
        return pow(x, n);
    }
    private double pow(double x, int n) {
        double res = 1;
        if(n != 0) {
            if(n > 0) {
                res = x * pow(x, --n);
            } else {
                n = Math.abs(n);
                res = 1 / (x * pow(x, --n));
            }
        }
        return res;
    }
}
