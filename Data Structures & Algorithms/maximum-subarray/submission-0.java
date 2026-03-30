class Solution {
    public int maxSubArray(int[] nums) {
        int res = dfs(0, nums, false);
        return res;
    }
    private int dfs(int i, int[] nums, boolean flag) {
        if(i >= nums.length) return flag? 0 : -10000001;
        if(flag) {
            int res = Math.max(nums[i] + dfs(i+1, nums, true), 0);
            return res;
        }
        int res = Math.max(nums[i] + dfs(i+1, nums, true), dfs(i+1, nums, false));
        return res;
    }
}
