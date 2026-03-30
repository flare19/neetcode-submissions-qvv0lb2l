class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = cost[cost.length - 2], two = cost[cost.length - 1];
        int res = Integer.MAX_VALUE;
        for(int i=cost.length - 3; i>=0; i--) {
            int temp = one;
            one = cost[i] + Math.min(one, two);
            two = temp;
        }
        return Math.min(one, two);
    }
}
