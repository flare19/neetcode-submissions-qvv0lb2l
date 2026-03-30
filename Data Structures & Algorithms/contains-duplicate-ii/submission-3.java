class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0, r= k >= nums.length? nums.length-1 : k;
        while(r < nums.length) {
            Set<Integer> set = new HashSet<>();
            for(int i=l; i<=r; i++) {
                set.add(nums[i]);
            }
            if(set.size() != r-l+1) return true;
            r++;
            l++;
        }
        return false;
    }
}