class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean have0=false, have1=false, have2=false;
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                have0 = triplet[0] == target[0] || have0;
                have1 = triplet[1] == target[1] || have1;
                have2 = triplet[2] == target[2] || have2;
            }
        }
        return have0 && have1 && have2;
    }
}