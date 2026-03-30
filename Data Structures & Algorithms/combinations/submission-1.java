class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, subset, res);
        return res;
    }

    public void dfs(int i, int n, int k, List<Integer> subset, List<List<Integer>> res) {
        if(i > n || subset.size() == k) {
            if(subset.size() < k) return;
            res.add(new ArrayList<>(subset));
            return;
        }
        if(subset.size() > k) return;
        subset.add(i);
        dfs(i+1, n, k, subset, res);
        subset.removeLast();
        dfs(i+1, n, k, subset, res);
    }
}