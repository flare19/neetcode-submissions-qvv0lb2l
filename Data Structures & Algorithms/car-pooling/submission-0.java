class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> points = new ArrayList<>();

        for(int[] trip : trips) {
            points.add(new int[] {trip[1], trip[0]});
            points.add(new int[] {trip[2], -trip[0]});
        }

        points.sort((a, b) -> a[0] == b[0] ?
                Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int passengers = 0;
        for(int[] point : points) {
            passengers += point[1];
            if(passengers > capacity) {
                return false;
            }
        }
        return true;
    }
}