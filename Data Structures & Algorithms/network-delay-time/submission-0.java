class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edgeMap = new HashMap<>();
        for(int[] time : times) {
            edgeMap.computeIfAbsent(time[0], m -> new ArrayList<>()).add(
                new int[]{time[1], time[2]});
        }
        Map<Integer, Integer> distMap = new HashMap<>();
        distMap.put(k, 0);
        for(int i=1; i<n+1; i++) {
            distMap.putIfAbsent(i, Integer.MAX_VALUE);
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(
            Comparator.comparing(a -> a[1]));
        q.add(new int[]{k, 0});
        while(!q.isEmpty()){
            int[] edge = q.poll();
            int node = edge[0];
            int weight = edge[1];
            if(distMap.get(node) < weight) {
                continue;
            }
            if(!edgeMap.containsKey(node)) continue;
            for(int[] neighbors : edgeMap.get(node)) {
                if(distMap.get(neighbors[0]) > weight + neighbors[1]) {
                    distMap.put(neighbors[0], weight + neighbors[1]);
                    q.add(new int[]{neighbors[0], weight + neighbors[1]});
                }
            }
        }
        if(distMap.values().contains(Integer.MAX_VALUE)) return -1;
        return Collections.max(distMap.values());
    }
}
