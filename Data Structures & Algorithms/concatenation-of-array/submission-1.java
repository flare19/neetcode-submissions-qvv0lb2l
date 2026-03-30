class Solution {
    public int[] getConcatenation(int[] nums) {
        int reslen = nums.length * 2;
        int[] res = new int[reslen];
        for(int i=0; i<nums.length; i++) {
            res[i] = res[i+nums.length] = nums[i];
        }
        return res;
    }
}