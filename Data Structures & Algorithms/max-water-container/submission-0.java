class Solution {
    public int maxArea(int[] heights) {
        int area = 0, l = 0, r = heights.length - 1;
        while(l < r) {
            int temp = (r - l) * Math.min(heights[l], heights[r]);
            area = Math.max(temp, area);
            if(heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return area;
    }
}
