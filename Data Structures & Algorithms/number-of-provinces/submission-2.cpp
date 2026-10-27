class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<bool> visited(n, false);
        int count = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

private:
    void dfs(int i, vector<vector<int>>& isConnected, vector<bool>& visited) {
        visited[i] = true;
        int n = isConnected.size();
        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (isConnected[i][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, isConnected, visited);
            }
        }
    }
};