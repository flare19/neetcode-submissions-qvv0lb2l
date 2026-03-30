class Solution {
    int[][] dp;
    int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for(int n : nums) {
            totalSum += n;
        }
        dp = new int[nums.length + 1][2 * totalSum + 1];
        for(int i=0; i<nums.length + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(nums, target, 0, 0);
        return res;
    }
    private int dfs(int[] nums, int target, int i, int sum) {
        if(i == nums.length && sum == target) return 1;
        if(i == nums.length && sum != target) return 0;
        int shiftedIndex = sum + totalSum;
        if(dp[i][shiftedIndex] != -1) return dp[i][shiftedIndex];
        int res = dfs(nums, target, i+1, sum + nums[i]) + dfs(nums, target, i+1, sum - nums[i]);
        dp[i][shiftedIndex] = res;
        return res;
    }
}
