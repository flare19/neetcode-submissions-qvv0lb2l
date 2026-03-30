class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, curr, res, target);
        return res;
    }

    private void dfs(int i, int[] candidates, List<Integer> curr, List<List<Integer>> res, int target) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || i >= candidates.length) {
            return;
        }
        curr.add(candidates[i]);
        dfs(i+1, candidates, curr, res, target - candidates[i]);
        curr.remove(curr.size() - 1);
        while(i < candidates.length - 1) {
            if(candidates[i] == candidates[i+1]) {
                i++;
                continue;
            }
            break;
        }
        dfs(i+1, candidates, curr, res, target);
    }
}
