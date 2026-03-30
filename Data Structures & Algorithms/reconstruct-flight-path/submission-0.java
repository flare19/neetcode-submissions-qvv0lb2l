class Solution {
    private int n;
    private Map<String, PriorityQueue<String>> airportMap;
    private Map<String, Integer> in, out;
    private List<String> path;
    private int edgeCount;

    public List<String> findItinerary(List<List<String>> tickets) {
        airportMap = new HashMap<>();
        n = airportMap.size();
        in = new HashMap<>();
        out = new HashMap<>();
        path = new ArrayList<>();
        for(List<String> ticket : tickets) {
            airportMap.computeIfAbsent(ticket.get(0), k ->
                    new PriorityQueue<>()).add(ticket.get(1));

            in.put(ticket.get(1), in.getOrDefault(ticket.get(1), 0) + 1);
            out.put(ticket.get(0), in.getOrDefault(ticket.get(0), 0) + 1);
            edgeCount++;
        }
        dfs("JFK");
        Collections.reverse(path);
        return path;
    }

    private void dfs(String node) {
        while(airportMap.containsKey(node) && !airportMap.get(node).isEmpty()) {
            String next = airportMap.get(node).poll();
            dfs(next);
        }
        path.add(node);
    }
}
