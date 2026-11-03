class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        int[][] zipped = new int[profits.length][2];
        for(int i=0; i<profits.length; i++) {
            zipped[i][0] = profits[i];
            zipped[i][1] = capitals[i];
        }

        PriorityQueue<int[]> maxProfit = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Arrays.sort(zipped, (a, b) -> Integer.compare(a[1], b[1]));
        int i=0;
        while(k > 0) {
            while(i < zipped.length && zipped[i][1] <= w) {
                maxProfit.offer(zipped[i]);
                i++;
            }
            if(maxProfit.isEmpty()) break;
            int[] top = maxProfit.poll();
            w += top[0];
            k--;
        }
        return w;
    }
}