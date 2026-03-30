class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1) return 1;
        int l=0, r=1, start=0, res=0;
        boolean leftGreater = !(arr[0] > arr[1]);
        while(r < arr.length) {
            if(arr[l] > arr[r] && !leftGreater) {
                l++;
                r++;
                leftGreater = true;
            } else if(arr[l] < arr[r] && leftGreater) {
                l++;
                r++;
                leftGreater = false;
            } else if(arr[l] == arr[r]) {
                leftGreater = (arr[l] > arr[r]);
                l++;
                r++;
                start = l;
            } else {
                start = l;
                leftGreater = !(arr[l] > arr[r]);
            }
            res = Math.max(res, (r-start));
        }
        return res;
    }
}