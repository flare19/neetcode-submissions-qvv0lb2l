class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curMin = 1, curMax = 1;
        for(int num : nums) {
            if(num == 0) {
                curMin = 1;
                curMax = 1;
            }
            int temp = curMax;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(num * temp, num * curMin), num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
