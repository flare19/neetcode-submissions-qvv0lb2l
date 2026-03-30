class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int res = 0;
        int maxL=0, maxR=0;
        while(l < r) {
            maxL = Math.max(maxL, height[l]);
            maxR = Math.max(maxR, height[r]);
            if(height[l] < height[r]) {
                res += maxL - height[l];
                l++;
            } else {
                res += maxR - height[r];
                r--;
            }
        }
        return res;
    }
}
