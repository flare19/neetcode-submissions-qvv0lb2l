class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int bestMin=nums[0], currMin=nums[0];
        int sum = accumulate(nums.begin(), nums.end(), 0);
        for (int i=1; i< nums.size(); i++) {
            currMin = min(nums[i] + currMin, nums[i]);
            bestMin = min(currMin, bestMin);
        }
        int bestMax=nums[0], currMax=nums[0];
        for (int i=1; i<nums.size(); i++) {
            currMax = max(nums[i] + currMax, nums[i]);
            bestMax = max(currMax, bestMax);
        }
        return bestMax < 0 ? bestMax : max(bestMax, sum - bestMin);
    }
};