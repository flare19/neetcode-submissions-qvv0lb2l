class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0; i<isConnected.length; i++) {
            List<Integer> islandsConnected = new ArrayList<>();
            for(int j=0; j<isConnected[0].length; j++) {
                if(isConnected[i][j] == 1) {
                    islandsConnected.add(j);
                }
            }
            adj.add(islandsConnected);
        }
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i<n; i++) {
            if(!visited.contains(i)) {
                count++;
                q.add(i);
                visited.add(i);
                while(!q.isEmpty()) {
                    int curr = q.poll();
                    for(int neighbor : adj.get(curr)) {
                        if(!visited.contains(neighbor)) {
                            q.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        return count;
    }
}