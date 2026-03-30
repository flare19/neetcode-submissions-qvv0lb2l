class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        
        int left = 1; 
        int right = max;
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for(int p : piles) {
                hours += (int) Math.ceil((double)p / mid);
            }
            if(hours <= h) {
                res = Math.min(res, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
