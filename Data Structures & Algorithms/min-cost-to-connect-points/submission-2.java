class Solution {
    int[] parent;
    int[] rank;
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                q.add(new int[]{dist, i, j});
            }
        }
        int res = 0;
        int size = q.size();
        for(int i=0; i<size; i++) {
            int[] edge = q.poll();
            int weight = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(!union(u, v)) {
                continue;
            }
            res+= weight;
        }
        return res;
    }

    public int find(int n) {
        if(parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return false;
        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
