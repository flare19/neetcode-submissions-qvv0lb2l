class Solution {
    public boolean canJump(int[] nums) {
        boolean res = dfs(0, nums);
        return res;
    }
    private boolean dfs(int i, int[] nums) {
        if(i == nums.length - 1) return true;
        if(i >= nums.length) return false;
        for(int j=1; j<=nums[i]; j++) {
            if(dfs(i + j, nums)) return true;
        }
        return false;
    }
}
