class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        if(nums.length == 1) return nums[0];
        int currSum = 0;
        for(int n : nums) {
            currSum += n;
            currSum = Math.max(currSum, n);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
