class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int highest = 0;
        for(int num : nums) {
            set.add(num);
            highest = Math.max(highest, num);
        }
        for(int i=1; i<=highest; i++) {
            if(!set.contains(i)) return i;
        }
        return highest == 0 ? 1 : highest + 1; 
    }
}