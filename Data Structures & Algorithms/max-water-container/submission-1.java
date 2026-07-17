class Solution {
    public int maxArea(int[] heights) {
        int l=0, r= heights.length-1;
        int area = 0;
        while(l < r) {
            int currArea = (r-l) * Math.min(heights[l], heights[r]);
            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
            area = Math.max(area, currArea);
        }
        return area;
    }
}
