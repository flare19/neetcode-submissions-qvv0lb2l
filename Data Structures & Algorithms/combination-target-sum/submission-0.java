class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(0, res, curr, target, nums);
        return res;
    }

    public void dfs(int i, List<List<Integer>> res, List<Integer> curr, int target, int[] nums) {
        if(target == 0) {
            res.add(new ArrayList(curr));
            return;
        }
        if(target < 0 || i >= nums.length) {
            return;
        }
        curr.add(nums[i]);
        dfs(i, res, curr, target - nums[i], nums);
        curr.remove(curr.size()-1);
        dfs(i+1, res, curr, target, nums);
    }
}
