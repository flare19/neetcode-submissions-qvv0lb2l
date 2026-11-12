class Solution {
    public int removeDuplicates(int[] nums) {
        int l=1, r=1, n = nums.length;
        int res=1;
        while(r<n) {
            if(nums[r] != nums[r-1]) {
                nums[l] = nums[r];
                l++;
                res++;
            }
            r++;
        }
        return res;
    }
}