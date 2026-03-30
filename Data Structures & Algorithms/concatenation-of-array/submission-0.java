class Solution {
    public int[] getConcatenation(int[] nums) {
        int reslen = nums.length * 2;
        int[] res = new int[reslen];
        for(int i=0; i<nums.length; i++) {
            res[i] = nums[i];
        }
        for(int i=nums.length; i<reslen; i++) {
            res[i] = nums[i-nums.length];
        }
        return res;
    }
}