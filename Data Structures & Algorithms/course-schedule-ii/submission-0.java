class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int[] prereq : prerequisites) {
            preMap.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }

        for(int course=0; course < numCourses; course++) {
            if(!dfs(preMap, res, visited, course, cycle)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i=0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    private boolean dfs(Map<Integer, List<Integer>> preMap, List<Integer> res, Set<Integer> visited, int crs, Set<Integer> cycle) {
        if(visited.contains(crs)) {
            return true;
        }
        if(cycle.contains(crs)) {
            return false;
        }
        cycle.add(crs);
        for(int pre : preMap.getOrDefault(crs, Collections.emptyList())) {
            if(!dfs(preMap, res, visited, pre, cycle)) {
                return false;
            }
        }
        cycle.remove(crs);
        visited.add(crs);
        res.add(crs);
        return true;
    }
}
