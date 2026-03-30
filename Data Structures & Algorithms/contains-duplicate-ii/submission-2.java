class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0, r= k >= nums.length? nums.length-1 : k;
        while(r < nums.length) {
            for(int i=l; i<r; i++) {
                if(nums[i] == nums[r]) return true;
            }
            r++;
            l++;
        }
        return false;
    }
}