class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = Arrays.stream(gas).sum();
        int sumCost = Arrays.stream(cost).sum();
        if(sumGas < sumCost) return -1;
        int totalSum = 0;
        int currSum = 0;
        int start = 0;
        for(int i=0; i<gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSum += diff;
            currSum += diff;
            if(currSum < 0) {
                currSum = 0;
                start = i+1;
            }
        }
        return totalSum >= 0? start : -1;
    }
}
