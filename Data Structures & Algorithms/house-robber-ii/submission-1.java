class Solution {
    int[] dp;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        dp = new int[nums.length - 1];
        Arrays.fill(dp, -1);
        int rob_house1 = dfs(Arrays.copyOfRange(nums, 0, nums.length-1), 0);
        Arrays.fill(dp, -1);
        int skip_house1 = dfs(Arrays.copyOfRange(nums, 1, nums.length), 0);
        return Math.max(rob_house1, skip_house1);
    }
    private int dfs(int[] nums, int i) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        dp[i] = Math.max(nums[i] + dfs(nums, i+2), dfs(nums, i+1));
        return dp[i];
    }
}
