class Solution {
    public int trap(int[] heights) {
        int l=0, r=heights.length-1, maxL = 0, maxR=0, res=0;
        while(l<r) {
            maxL = Math.max(heights[l], maxL);
            maxR = Math.max(heights[r], maxR);
            if(heights[l] < heights[r]) {
                res += maxL - heights[l];
                l++;
            } else {
                res += maxR - heights[r];
                r--;
            }
        }
        return res;
    }
}
