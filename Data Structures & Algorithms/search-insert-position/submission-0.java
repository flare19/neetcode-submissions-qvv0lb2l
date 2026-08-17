class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1;
        if(target > nums[r]) {
            return nums.length;
        }
        if(target < nums[l]) {
            return 0;
        }
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < target) {
                l = mid+1;
            } else if(nums[mid] > target) {
                r = mid;
            } else {
                return mid;
            }
        }
        return r;
    }
}