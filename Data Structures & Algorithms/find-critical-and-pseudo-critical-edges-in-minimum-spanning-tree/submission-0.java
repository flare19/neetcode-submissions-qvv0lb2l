public class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] sortedEdges = new int[edges.length][4];
        for(int i=0; i<edges.length; i++) {
            sortedEdges[i][0] = edges[i][0];
            sortedEdges[i][1] = edges[i][1];
            sortedEdges[i][2] = edges[i][2];
            sortedEdges[i][3] = i;
        }
        Arrays.sort(sortedEdges, (a, b) -> a[2] - b[2]);
        int base = kruskal(n, sortedEdges, -1, -1);
        List<Integer> critical= new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        for(int i=0; i<edges.length; i++) {
            int id = sortedEdges[i][3];
            int skip = kruskal(n, sortedEdges, id, -1);
            int force = kruskal(n, sortedEdges, -1, id);
            if(force == base && skip == base) {
                pseudo.add(sortedEdges[i][3]);
            } else if (force == base && skip > base) {
                critical.add(sortedEdges[i][3]);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pseudo);
        return res;
    }

    public int kruskal(int n, int[][] edges, int skip, int force) {
        DSU dsu = new DSU(n);
        int weight = 0;
        int used = 0;

        if(force != -1) {
            int[] forceEdge = new int[4];
            for(int i=0; i<edges.length; i++) {
                if(edges[i][3] == force) {
                    forceEdge = edges[i];
                }
            }
            if(dsu.union(forceEdge[0], forceEdge[1])) {
                weight += forceEdge[2];
                used++;
            }
        }

        for(int[] edge : edges) {
            if(edge[3] == skip) continue;
            if(dsu.union(edge[0], edge[1])) {
                weight += edge[2];
                used++;
            }
        }

        return used == n-1 ? weight : Integer.MAX_VALUE;
    }
}

class DSU {
    int[] parent;
    DSU(int n) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
    }

    int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if(px == py) return false;
        parent[px] = py;
        return true;
    }
}