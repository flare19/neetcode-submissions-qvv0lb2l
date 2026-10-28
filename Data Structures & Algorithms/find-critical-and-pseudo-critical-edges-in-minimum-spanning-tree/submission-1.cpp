class DSU {
public:
    vector<int> parent;
    DSU(int n) {
        parent.resize(n);
        for (int i=0; i<n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    bool unite(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        parent[px] = py;
        return true;
    }
};

class Solution {
public:
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {
        vector<vector<int>> sorted_edges(edges.size(), vector<int>(4));
        for (int i=0; i<edges.size(); i++) {
            sorted_edges[i][0] = edges[i][0];
            sorted_edges[i][1] = edges[i][1];
            sorted_edges[i][2] = edges[i][2];
            sorted_edges[i][3] = i;
        }
        sort(sorted_edges.begin(), sorted_edges.end(), [](auto& a, auto& b) {return a[2] < b[2]; });
        int base = kruskal(n, sorted_edges, -1, -1);
        vector<int> critical;
        vector<int> pseudo;
        for (int i=0; i<edges.size(); i++) {
            int id = sorted_edges[i][3];
            int skip = kruskal(n, sorted_edges, id, -1);
            int force = kruskal(n, sorted_edges, -1, id);
            if (force == base && skip == base) {
                pseudo.push_back(id);
            } else if ( force == base && skip > base) {
                critical.push_back(id);
            }
        }
        return {critical, pseudo};
    }

    int kruskal(int n, vector<vector<int>>& edges, int skip, int force) {
        DSU dsu(n);
        int weight = 0;
        int used = 0;

        if (force != -1) {
            vector<int> forceEdge;
            for (int i=0; i<edges.size(); i++) {
                if (edges[i][3] == force) {
                    forceEdge = edges[i];
                }
            }
            if (dsu.unite(forceEdge[0], forceEdge[1])) {
                weight += forceEdge[2];
                used++;
            }
        }

        for (const auto& edge : edges) {
            if (edge[3] == skip) continue;
            if (dsu.unite(edge[0], edge[1])) {
                weight += edge[2];
                used++;
            }
        }

        return used == n-1 ? weight : INT_MAX;
    }
};

