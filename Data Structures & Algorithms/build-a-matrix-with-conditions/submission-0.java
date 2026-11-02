class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, List<Integer>> rowCon = new HashMap<>();
        Map<Integer, List<Integer>> colCon = new HashMap<>();
        for(int[] rowCondition : rowConditions) {
            rowCon.computeIfAbsent(rowCondition[0], kr -> new ArrayList<>()).add(rowCondition[1]);
        }
        for(int[] colCondition : colConditions) {
            colCon.computeIfAbsent(colCondition[0], kc -> new ArrayList<>()).add(colCondition[1]);
        }
        List<Integer> finalRow = new ArrayList<>();
        int[] visitedRow = new int[k+1];
        List<Integer> finalCol = new ArrayList<>();
        int[] visitedCol = new int[k+1];
        for(int i=1; i<k+1; i++) {
            boolean hasCycleRow = orderDfs(i, visitedRow, rowCon, finalRow);
            boolean hasCycleCol = orderDfs(i, visitedCol, colCon, finalCol);
            if(!hasCycleCol || !hasCycleRow) {
                return new int[0][];
            }
        }

        int[][] res = new int[k][k];
        Collections.reverse(finalRow);
        Collections.reverse(finalCol);
        int[] rowPos = new int[k+1];
        int[] colPos = new int[k+1];
        for(int i=0; i<k; i++) {
            rowPos[finalRow.get(i)] = i;
            colPos[finalCol.get(i)] = i;
        }
        for(int i=1; i<k+1; i++) {
            res[rowPos[i]][colPos[i]] = i;
        }
        return res;
    }

    public boolean orderDfs(int i, int[] visited, Map<Integer, List<Integer>> map, List<Integer> res) {
        if(visited[i] == 1) {
            return true;
        }
        if(visited[i] == 2) {
            return false;
        }

        visited[i] = 2;

        if(map.containsKey(i)) {
            for(int neighbor : map.get(i)) {
                if(!orderDfs(neighbor, visited, map, res)) return false;
            }
        }

        visited[i] = 1;
        res.add(i);
        return true;
    }
}