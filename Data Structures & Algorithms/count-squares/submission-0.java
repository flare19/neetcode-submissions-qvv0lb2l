class CountSquares {

    private List<List<Integer>> points;
    private Map<List<Integer>, Integer> countPts;
    public CountSquares() {
        countPts = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        List<Integer> pt = new ArrayList<>();
        for(int p : point) {
            pt.add(p);
        }
        points.add(pt);
        countPts.put(pt, countPts.getOrDefault(pt, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for(List<Integer> p : points) {
            int x = p.get(0), y = p.get(1);
            if(Math.abs(px - x) != Math.abs(py - y) || x == px || y == py) {
                continue;
            }
            res += countPts.getOrDefault(Arrays.asList(x, py), 0) * countPts.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }
}
