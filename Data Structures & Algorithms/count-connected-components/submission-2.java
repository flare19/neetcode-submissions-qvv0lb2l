class Solution {
    private int[] parent;
    private int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i< parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges) {
            int u=edge[0], v=edge[1];
            if(!union(u, v)) {
                continue;
            }
            n--;
        }
        return n;
    }
    private int find(int n) {
        if(n != parent[n]) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) {
            return false;
        }
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