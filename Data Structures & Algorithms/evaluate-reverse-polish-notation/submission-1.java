class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> eval = new Stack<>();
        for(String c : tokens) {
            if(c.equals("+")) {
                eval.push((eval.pop() + eval.pop()));
            } else if(c.equals("-")) {
                int a = eval.pop();
                int b = eval.pop();
                eval.push((b - a));
            } else if(c.equals("*")) {
                eval.push((eval.pop() * eval.pop()));
            } else if(c.equals("/")) {
                int a = eval.pop();
                int b = eval.pop();
                eval.push((b / a));
            } else {
                eval.push(Integer.parseInt(c));
            }
        }
        return eval.peek();
    }
}
