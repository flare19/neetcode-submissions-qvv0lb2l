class Solution {
    public boolean isValid(String s) {
        Stack<Character> confirm = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                if(!confirm.isEmpty() && confirm.peek() == map.get(c)) {
                    confirm.pop();
                } else {
                    return false;
                }
            } else {
                confirm.push(c);
            }
        }
        return confirm.isEmpty();
    }
}
