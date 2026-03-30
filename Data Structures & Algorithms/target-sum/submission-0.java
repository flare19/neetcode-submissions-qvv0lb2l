class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int res = dfs(nums, target, 0, 0);
        return res;
    }
    private int dfs(int[] nums, int target, int i, int sum) {
        if(i == nums.length && sum == target) return 1;
        if(i == nums.length && sum != target) return 0;
        int res = dfs(nums, target, i+1, sum + nums[i]) + dfs(nums, target, i+1, sum - nums[i]);
        return res;
    }
}
