class Solution {
    public int maxProfit(int[] prices) {
        int l=0, r=1;
        int profit=0;
        while(r < prices.length) {
            if(prices[l] < prices[r]) {
                int temp = prices[r] - prices[l];
                profit = Math.max(temp, profit);
            } else {
                l = r;
            }
            r++;
        }
        return profit;
    }
}
