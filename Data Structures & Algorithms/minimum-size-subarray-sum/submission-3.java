class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 1) return nums[0] == target? 1 : 0;
        int l=0, r=0, res=Integer.MAX_VALUE, temp=0;
        while(r < nums.length) {
            temp += nums[r];
            r++;
            if(temp >= target) {
                while(temp >= target) {
                    temp -= nums[l];
                    l++;
                }
                res = Math.min(res, (r-l+1));
            }
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}