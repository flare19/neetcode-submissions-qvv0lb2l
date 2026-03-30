class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int first = prices[0], max = 0;
        for(int i=1; i < prices.length; i++) {
            if((prices[i] - first) > 0) {
                max += (prices[i] - first);
            }
            first = prices[i];
        }
        return max;
    }
}