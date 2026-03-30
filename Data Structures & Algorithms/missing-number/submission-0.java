class Solution {
    public int missingNumber(int[] nums) {
        int l = nums.length+1;
        int[] expected = new int[l];
        for(int i=0; i<l; i++) {
            expected[i] = i;
        }
        int xor = 0;
        for(int num : expected) {
            xor ^= num;
        }
        for(int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
