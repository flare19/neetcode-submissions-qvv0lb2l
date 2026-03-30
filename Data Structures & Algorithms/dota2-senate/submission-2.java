class Solution {
    public String predictPartyVictory(String senate) {
        int Rc = 0, Dc = 0;
        Deque<Character> q = new LinkedList<>();
        for(char c : senate.toCharArray()) {
            q.add(c);
            if(c == 'R') {
                Rc++;
            } else {
                Dc++;
            }
        }
        int Rb = 0, Db = 0;
        while(!q.isEmpty()) {
            if(Rc == 0) return "Dire";
            if(Dc == 0) return "Radiant";
            char curr = q.poll();
            if(curr == 'R' && Db == 0) {
                q.add('R');
                Rb++;
            } else if(curr == 'R' && Db != 0) {
                Db--;
                Rc--;
            } else if(curr == 'D' && Rb == 0) {
                q.add('D');
                Db++;
            } else {
                Rb--;
                Dc--;
            }
        }
        return "";
    }
}