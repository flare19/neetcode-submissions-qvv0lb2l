class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(0, nums, 0);
    }

    private int dfs(int i, int[] nums, int total) {
        if(i >= nums.length) {
            return total;
        }
        return dfs(i+1, nums, total ^ nums[i]) + dfs(i+1, nums, total);
    }
}