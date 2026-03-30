class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=-1, candidate2=-1;
        int count1=0, count2=0;
        for(int n : nums) {
            if(n == candidate1) {
                count1++;
            } else if(n == candidate2) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for(int n : nums) {
            if(n == candidate1) count1++;
            if(n == candidate2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length / 3) res.add(candidate1);
        if(count2 > nums.length / 3) res.add(candidate2);

        return res;
    }
}