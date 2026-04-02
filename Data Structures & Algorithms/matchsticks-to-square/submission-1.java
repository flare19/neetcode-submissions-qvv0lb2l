class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int matchstick : matchsticks) {
            sum += matchstick;
        }
        if(sum % 4 != 0) return false;
        for(int matchstick : matchsticks) {
            if(matchstick > (sum / 4)) return false;
        }
        boolean[] visited = new boolean[matchsticks.length];
        Arrays.sort(matchsticks);
        for(int i=0; i<matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - i - 1];
            matchsticks[matchsticks.length - i - 1] = temp;
        }
        return dfs(matchsticks, sum, 0, visited, 0);
    }

    private boolean dfs(int[] matchsticks, int sum, int curr, boolean[] visited, int sides) {
        if(sides == 4) return true;
        if(curr > sum / 4) return false;

        if(curr == sum / 4) {
            return dfs(matchsticks, sum, 0, visited, sides+1);
        }
        boolean res = false;
        for(int j=0; j<matchsticks.length; j++) {
            if(!visited[j]) {
                visited[j] = true;
                res = res || dfs(matchsticks, sum, curr + matchsticks[j], visited, sides);
                visited[j] = false;
            }
        }
        return res;
    }
}