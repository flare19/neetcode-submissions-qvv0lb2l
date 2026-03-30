class Solution {
    Map<List<Integer>, Integer> dp;
    public int maxCoins(int[] nums) {
        dp = new HashMap<>();
        List<Integer> numsList = new ArrayList<>();
        for(int num : nums) {
            numsList.add(num);
        }
        numsList.addFirst(1);
        numsList.add(1);
        int res = dfs(1, numsList.size() - 2, numsList);
        return res;
    }
    private int dfs(int l, int r, List<Integer> nums) {
        if(l > r) return 0;
        if(dp.containsKey(Arrays.asList(l, r))) return dp.get(Arrays.asList(l, r));
        dp.put(Arrays.asList(l , r), 0);
        for(int i=l; i<r+1; i++) {
            int coins = nums.get(l-1) * nums.get(i) * nums.get(r+1);
            coins += dfs(i+1, r, nums) + dfs(l, i-1, nums);
            dp.put(Arrays.asList(l, r), Math.max(dp.get(Arrays.asList(l, r)), coins));
        }
        return dp.get(Arrays.asList(l, r));
    }
}
