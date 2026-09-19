class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids) {
            if(asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            if(stack.isEmpty() && asteroid < 0 || stack.peek() < 0) {
                stack.push(asteroid);
                continue;
            }
            if(!stack.isEmpty() && asteroid < 0) {
                if(stack.peek() > Math.abs(asteroid)) continue;
                boolean flag = false;
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(asteroid)) {
                    int destroyed = stack.pop();
                    if(destroyed == Math.abs(asteroid)) {
                        flag = true;
                        break;
                    }
                }
                if(!stack.isEmpty() && stack.peek() > Math.abs(asteroid)) continue;
                if(flag) continue;
                stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for(int i=0; i<stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }
}