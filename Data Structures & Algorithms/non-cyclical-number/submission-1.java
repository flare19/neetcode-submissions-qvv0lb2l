class Solution {
    public boolean isHappy(int n) {
        Set<Integer> repeat = new HashSet<>();
        int key;
        while(true) {
            int[] digits = new int[4];
            int i = 0;
            while (n > 0) {
                digits[i] = n % 10;
                i++;
                n = n / 10;
            }
            key = square(digits);
            if (repeat.contains(key)) return false;
            repeat.add(key);
            n = key;
            if (key == 1) return true;
        }
    }
    private int square(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res += (int) Math.pow(num, 2);
        }
        return res;
    }
}
