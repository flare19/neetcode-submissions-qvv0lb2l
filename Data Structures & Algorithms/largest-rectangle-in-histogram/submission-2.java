class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int res = 0;
        int len = heights.length;
        for(int i=0; i<heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i] ) {
                int[] entry = stack.pop();
                res = Math.max(res, (i - entry[0]) * entry[1]);
                start = entry[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        for(int[] entry : stack) {
            res = Math.max(res, (len - entry[0]) * entry[1]);
        }
        return res;
    }
}
