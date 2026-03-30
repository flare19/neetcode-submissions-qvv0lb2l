class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> visited = new HashSet<>();
        int minCost = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        q.offer(new int[]{0,0});

        while(visited.size() < n) {
            int current[] = q.poll();
            int node = current[1];
            int weight = current[0];

            if(visited.contains(node)) continue;

            visited.add(node);
            minCost += weight;

            for(int i=0; i<n; i++) {
                if(!visited.contains(i)) {
                    int manhattan = Math.abs(points[node][0] - points[i][0]) +
                            Math.abs(points[node][1] - points[i][1]);
                    q.offer(new int[] {manhattan, i});
                }
            }
        }
        return minCost;
    }
}
