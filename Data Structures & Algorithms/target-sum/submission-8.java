class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int n : nums) {
            totalSum += n;
        }
        if(target > totalSum) return 0;
        int[][] dp = new int[nums.length + 1][2 * totalSum + 1];
        dp[0][totalSum] = 1; //this means that there is exactly 1 way to reach sum 0 when 0  elements are selected.
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<2 * totalSum + 1; j++) { //this is the tricky part, indexing is screwed here, from -sum to +sum
                if(j + nums[i] <= 2 * totalSum) dp[i+1][j + nums[i]] += dp[i][j];
                if(j - nums[i] >= 0) dp[i+1][j - nums[i]] += dp[i][j];
            }
        }
        return dp[nums.length][totalSum + target];
    }
}
