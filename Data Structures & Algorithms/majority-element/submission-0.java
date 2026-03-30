class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = nums[0];
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == res){
                count++;
            } else {
                if(count > 0) {
                    count--;
                } else {
                    count = 1;
                    res = nums[i];
                }
            }
        }
        return res;
    }
}