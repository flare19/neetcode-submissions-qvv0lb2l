class Solution {
    public int jump(int[] nums) {
        int res = dfs(0, nums);
        return res;
    }
    private int dfs(int i, int[] nums) {
        if(i == nums.length - 1) return 0;
        if(i >= nums.length) return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int j=1; j<=nums[i]; j++){
            int candidate = dfs(i+j, nums);
            if(candidate != Integer.MAX_VALUE) {
                res = Math.min(res, 1 + candidate);
            }
        }
        return res;
    }
}
