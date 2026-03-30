class Solution {
    private int[] parent;
    private int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges) {
            int u = edge[0], v=edge[1];
            if(!union(u, v)) {
                return new int[]{u, v};
            }
        }
        return new int[]{};
    }

    private int find(int n) {
        if(n != parent[n]) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    private boolean union(int a, int b) {
        int par1 = find(a);
        int par2 = find(b);
        if(par1 == par2) {
            return false;
        }

        if(rank[par1] > rank[par2]) {
            parent[par2] = par1;
            rank[par1] += rank[par2];
        } else {
            parent[par1] = par2;
            rank[par2] += rank[par1];
        }
        return true;
    }
}
