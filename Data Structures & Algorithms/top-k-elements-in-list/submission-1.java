class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] count = new List[nums.length + 1];
        for(int i=0; i< count.length; i++) {
            count[i] = new ArrayList<>();
        }

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count[entry.getValue()].add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for(int i=count.length - 1; i>=0; i--) {
            for(int n : count[i]) {
                res.add(n);
                if(res.size() == k) {
                    return res.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }
        return new int[0];
    }
}
