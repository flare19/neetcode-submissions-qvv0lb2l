class Solution {
    int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        boolean res = dfs(0, nums);
        return res;
    }
    private boolean dfs(int i, int[] nums) {
        if(i == nums.length - 1) return true;
        if(i >= nums.length) return false;
        if(dp[i] != -1) return dp[i] == 1;
        for(int j=1; j<=nums[i]; j++) {
            if(dfs(i + j, nums)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
}
