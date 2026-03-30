class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] edge : edges) {
            edgeMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int res=0;
        for(int i=0; i<n; i++) {
            if(visited.contains(i)) {
                continue;
            }
            dfs(i, visited, edgeMap);
            res++;
        }
        return res;
    }

    private void dfs(int i, Set<Integer> visited, Map<Integer, List<Integer>> edgeMap) {
        if(visited.contains(i)) {
            return;
        }
        visited.add(i);
        for(int n : edgeMap.getOrDefault(i, Collections.emptyList())) {
            dfs(n, visited, edgeMap);
        }
        return;
    }
}
