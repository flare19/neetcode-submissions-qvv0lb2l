class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] distMap = new int[n][k+2];
        Map<Integer, List<int[]>> edgeMap = new HashMap<>();
        for(int[] flight : flights) {
            edgeMap.computeIfAbsent(flight[0],
                    k1 -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        for(int[] dist : distMap) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        for(int i=0; i<k+1; i++) {
            distMap[src][i] = 0;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        q.add(new int[]{0, src, k+1});
        while(!q.isEmpty()) {
            int[] edge = q.poll();
            int cost=edge[0], node=edge[1], stops=edge[2];
            if(stops == 0 || cost > distMap[node][stops]) continue;
            if(!edgeMap.containsKey(node)) continue;
            for(int[] nei : edgeMap.get(node)){
                int newCost = nei[1] + cost;
                int newStops = stops - 1;
                if(distMap[nei[0]][newStops] > newCost) {
                    distMap[nei[0]][newStops] = newCost;
                    q.add(new int[]{newCost, nei[0], newStops});
                }
            }
        }
        int min = distMap[dst][0];
        for(int i=0; i<k+2; i++) {
            min = Math.min(min, distMap[dst][i]);
        }
        return min != Integer.MAX_VALUE? min : -1;
    }
}
