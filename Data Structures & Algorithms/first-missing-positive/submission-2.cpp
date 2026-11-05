class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        for (int i=0; i<nums.size(); i++) {
            while (nums[i] <= nums.size() && nums[i] >= 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i=0; i<nums.size(); i++) {
            if (nums[i] == i+1) {
                continue;
            }
            return i+1;
        }
        return nums.size() + 1;
    }
};