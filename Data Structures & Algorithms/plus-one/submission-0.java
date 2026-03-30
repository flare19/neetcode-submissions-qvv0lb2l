class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        for(int digit : digits) {
            res.add(digit);
        }
        int carry=0;
        if(res.get(digits.length - 1) < 9) {
            res.set(digits.length - 1, res.get(digits.length - 1) + 1);
        } else if(res.get(digits.length - 1) == 9) {
            carry=1;
            res.set(digits.length - 1, 0);
        }
        for(int i=digits.length-2; i>=0; i--) {
            if(carry == 1) {
                if(res.get(i) < 9) {
                    res.set(i, res.get(i) + 1);
                    carry=0;
                } else {
                    res.set(i, 0);
                }
            }
        }
        if(carry == 1) {
            res.addFirst(1);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
