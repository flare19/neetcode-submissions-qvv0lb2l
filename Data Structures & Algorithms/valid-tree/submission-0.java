class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for(int[] edge : edges) {
            edgeMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        if(!dfs(0, visited, edgeMap, -1)) {
            return false;
        }

        return visited.size() == n ? true : false;
    }

    private boolean dfs(int i, Set<Integer> visited, Map<Integer, List<Integer>> edgeMap, int parent) {
        if(visited.contains(i)) {
            return false;
        }
        visited.add(i);
        for(int n : edgeMap.getOrDefault(i, Collections.emptyList())) {
            if(parent == n) {
                continue;
            }
            if(!dfs(n, visited, edgeMap, i)) {
                return false;
            }
        }
        return true;
    }
}
