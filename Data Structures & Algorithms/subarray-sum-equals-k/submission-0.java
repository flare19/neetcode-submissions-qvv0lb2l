class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        int curr = prefix[1] = nums[0];
        for(int i=1; i<nums.length; i++) {
            curr += nums[i];
            prefix[i+1] = curr;
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int pre : prefix) {
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}