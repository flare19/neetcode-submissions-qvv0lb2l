class Solution {
    Map<Integer, List<Integer>> crsMap = new HashMap<>();
    Map<Integer, Set<Integer>> reachable = new HashMap<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for(int[] pre : prerequisites) {
            crsMap.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }
        for(int i=0; i<numCourses; i++) {
            crsMap.putIfAbsent(i, new ArrayList<>());
        }
        for(int i=0; i<numCourses; i++) {
            dfs(i);
        }
        for(int[] query : queries) {
            if(reachable.get(query[0]).contains(query[1])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public void dfs(int crs) {
        if(reachable.containsKey(crs)) {
            return;
        }
        reachable.put(crs, new HashSet<>());
        for(int nextCourse : crsMap.get(crs)) {
            dfs(nextCourse);
            reachable.get(crs).add(nextCourse);
            reachable.get(crs).addAll(reachable.get(nextCourse));
        }
    }
}