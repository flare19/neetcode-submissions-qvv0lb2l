class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids) {
            if(asteroid > 0) {
                stack.add(asteroid);
            } else {
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.add(asteroid);
                    continue;
                }
                if(stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                }
                if(stack.peek() < Math.abs(asteroid)) {
                    while(!stack.isEmpty()) {
                        if(stack.peek() < 0) {
                            stack.add(asteroid);
                            break;
                        }
                        if(stack.peek() < Math.abs(asteroid)) {
                            stack.pop();
                        } else if(stack.peek() == Math.abs(asteroid)) {
                            stack.pop();
                            break;
                        } else {
                            break;
                        }
                    }
                    if(stack.isEmpty()) stack.add(asteroid);
                }
            }
        }
        int i=0;
        int[] res = new int[stack.size()];
        for(int num : stack) {
            res[i++] = num;
        }
        return res;
    }
}