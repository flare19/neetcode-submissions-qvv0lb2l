class Solution {
    public int openLock(String[] deadends, String target) {
        int res = 0;
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>(List.of(deadends));
        if(visited.contains("0000")) return -1;
        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0; j<size; j++) {
                String comb = q.poll();
                if(comb.equals(target)) return res;
                char[] arr = comb.toCharArray();
                for(int i=0; i<4;i++) {
                    char original = arr[i];
                    arr[i] = (original == '9') ? '0' : (char)(original + 1);
                    String next1 = new String(arr);
                    if (!visited.contains(next1)) {
                        q.offer(next1);
                        visited.add(next1);
                    }
                    arr[i] = (original == '0') ? '9' : (char)(original - 1);
                    String next2 = new String(arr);
                    if (!visited.contains(next2)) {
                        q.offer(next2);
                        visited.add(next2);
                    }

                    arr[i] = original;
                }
            }
            res++;
        }
        return -1;
    }
}