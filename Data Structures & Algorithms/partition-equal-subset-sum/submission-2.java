class Solution {
    public boolean canPartition(int[] nums) {
        int res = 0;
        for(int n : nums) res += n;
        if(res % 2 != 0) return false;
        int target = res / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i=nums.length-1; i>= 0; i--) {
            Set<Integer> temp = new HashSet<>();
            for(int n : set) {
                if(n + nums[i] == target) return true;
                temp.add(n + nums[i]);
                temp.add(n);
            }
            set = temp;
        }
        return set.contains(target);
    }
}
