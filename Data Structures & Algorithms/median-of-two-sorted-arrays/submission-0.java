class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int total = nums1.length + nums2.length;
        int half = (total) / 2;
        int l = 0;
        int r = nums1.length;
        while(l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int Aright = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright) {
                if(total % 2 == 0) {
                    return (double)(Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
                }
                return Math.min(Aright, Bright);
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1; 
            }
        }
        return -1;
    }
}
