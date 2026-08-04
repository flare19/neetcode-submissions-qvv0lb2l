class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.freq, a.freq)
        );
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            pq.offer(pair);
        }
        Queue<Pair> cooldown = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            sb.append(pair.character);
            pair.freq -= 1;
            if(!cooldown.isEmpty()) {
                pq.offer(cooldown.poll());
            }
            if(pair.freq > 0) {
                cooldown.offer(pair);
            }
        }
        return cooldown.isEmpty()? sb.toString() : "";
    }
}

class Pair{
    char character;
    int freq;
    public Pair(char character, int freq) {
        this.character = character;
        this.freq = freq;
    }
}