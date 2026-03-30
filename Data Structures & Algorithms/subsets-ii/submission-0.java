class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, res, subset);
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> subset) {
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i+1, nums, res, subset);
        while(i < nums.length - 1) {
            if(nums[i] == nums[i+1]) {
                i++;
                continue;
            }
            break;
        }
        subset.remove(subset.size() - 1);
        dfs(i+1, nums, res, subset);
    }
}
