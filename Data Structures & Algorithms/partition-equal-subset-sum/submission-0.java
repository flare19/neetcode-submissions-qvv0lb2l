class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int res = 0;
        for(int n : nums) {
            res += n;
        }
        int rSum = res / 2;
        if(res % 2 != 0) return false;
        dp = new int[nums.length+1][rSum+1];
        for(int i=0; i < nums.length+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, nums, rSum);
    }
    private boolean dfs(int i, int[] nums, int rSum) {
        if(rSum == 0) return true;
        if(rSum < 0 || i == nums.length) return false;
        if(dp[i][rSum] != -1) return dp[i][rSum] == 1;
        if(dfs(i+1, nums, rSum - nums[i]) || dfs(i+1, nums, rSum)) {
            dp[i][rSum] = 1;
            return true;
        }
        dp[i][rSum] = 0;
        return false;
    }
}
