class Solution {
    public int maxCoins(int[] nums) {
        int[] numsUpdated = new int[nums.length + 2];
        for(int i=0; i<nums.length; i++) {
            numsUpdated[i+1] = nums[i];
        }
        numsUpdated[0] = numsUpdated[nums.length + 1] = 1;
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for(int l=nums.length; l>=1; l--) {
            for(int r=1; r<=nums.length; r++) {
                for(int i=l; i<=r; i++) {
                    int coins = numsUpdated[l-1] * numsUpdated[i] * numsUpdated[r+1];
                    coins += dp[i+1][r] + dp[l][i-1];
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }
        return dp[1][nums.length];
    }
}
