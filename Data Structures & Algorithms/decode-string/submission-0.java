class Solution {
    public String decodeString(String s) {
        Stack<Data> stack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            } else if (c == '[') {
                stack.push(new Data(num, curr.toString()));
                curr.setLength(0);
                num = 0;
            } else if (c == ']') {
                Data node = stack.pop();
                StringBuilder newCurr = new StringBuilder();
                newCurr.append(node.curr);
                for(int i=0; i<node.num; i++){
                    newCurr.append(curr);
                }
                curr = newCurr;
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}

class Data{
    int num;
    String curr;
    public Data(int num, String curr) {
        this.num = num;
        this.curr = curr;
    }
}