class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target){
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(dp[target] != -1) return dp[target];
        int res = 0;
        for(int num : nums) {
            res += dfs(nums, target-num);
        }
        dp[target] = res;
        return res;
    }
}