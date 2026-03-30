class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int one = Math.max(nums[nums.length - 2], nums[nums.length - 1]),  
                two = nums[nums.length - 1];
        for(int i=nums.length-3; i>=0; i--) {
            int temp = one;
            one = Math.max(two + nums[i], temp);
            two = temp;
        }
        return Math.max(one, two);
    }
}
