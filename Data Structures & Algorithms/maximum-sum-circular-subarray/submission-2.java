class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMin = nums[0], bestMin = nums[0];
        int sum = Arrays.stream(nums).sum();
        for(int i=1; i<nums.length; i++) {
            currMin = Math.min(currMin + nums[i], nums[i]);
            bestMin = Math.min(bestMin, currMin);
        }
        int currMax = nums[0], bestMax = nums[0];
        for(int i=1; i<nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            bestMax = Math.max(bestMax, currMax);
        }
        if(sum == bestMin) {
            return bestMax;
        }
        return Math.max(sum - bestMin, bestMax);
    }
}