class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int res = 0;
        for(int i=0; i<isConnected.length; i++) {
            if(!visited[i]) {
                dfs(i, isConnected, visited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        for(int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if(isConnected[i][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, isConnected, visited);
            }
        }
    }
}