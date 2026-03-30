class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        int n = nums.length;
        dp[n] = 1;
        for(int i=n-1; i>= 0; i--) {
            for(int j=i+1; j<n; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for(int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }
}
