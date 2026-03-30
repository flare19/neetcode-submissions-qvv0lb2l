class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = weights[0], r = 0;
        for(int weight : weights) {
            if(weight > l) {
                l = weight;
            }
            r += weight;
        }
        while(l < r) {
            int mid = (l + r) / 2;
            int shipDays = 1;
            int temp = 0;
            for(int weight : weights) {
                if(temp + weight <= mid) {
                    temp += weight;
                } else {
                    shipDays++;
                    temp = weight;
                }
            }
            if(shipDays <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}