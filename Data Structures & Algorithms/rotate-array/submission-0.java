class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);
    }

    private void rotate(int[] nums, int l, int r) {
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}