class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            res = Math.max(res, dfs(i, nums));
        }
        return res;
    }
    private int dfs(int i, int[] nums) {
        if(i == nums.length) return 0;
        int res = 1;
        for(int j=i+1; j < nums.length; j++) {
            if(nums[i] < nums[j]) {
                int curr = 1 + dfs(j , nums);
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
