class Solution {
    public List<Integer> majorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int num : nums) {
            if(map.get(num) > nums.length / 3 && !res.contains(num))
                res.add(num);
        }
        return res;
    }
}