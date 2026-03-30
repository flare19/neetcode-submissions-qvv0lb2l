class Solution {
    public int splitArray(int[] nums, int k) {
        int l = nums[0];
        int r = 0;
        for(int num : nums) {
            if(num > l) l = num;
            r += num;
        }
        while(l < r) {
            int mid = (l + r) / 2;

            if(canSplit(nums, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canSplit(int[] nums, int k, int mid) {
        int sum = 0;
        int numArrays = 1;
        for(int num : nums) {
            if(num + sum > mid) {
                numArrays++;
                sum = 0;
            }
            sum += num;
        }
        return numArrays <= k;
    }
}