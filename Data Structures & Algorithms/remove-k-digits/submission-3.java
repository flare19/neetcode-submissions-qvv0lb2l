class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char c : num.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && stack.peek() > c) {
                k--;
                stack.pop();
            }
            stack.push(c);
        }
        for(int i=0; i<k; i++) {
            stack.pop();
        }
        StringBuilder res = new StringBuilder();
        for(char c : stack) {
            res.append(c);
        }
        String ret = res.toString().replaceFirst("^0+", "");
        return ret.isEmpty()? "0" : ret;
    }
}
