class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] delta = new int[1001];
        for(int[] trip : trips) {
            delta[trip[1]] += trip[0];
            delta[trip[2]] -= trip[0];
        }
        int total = 0;
        for(int entry : delta) {
            total += entry;
            if(total > capacity) {
                return false;
            }
        }
        return true;
    }
}