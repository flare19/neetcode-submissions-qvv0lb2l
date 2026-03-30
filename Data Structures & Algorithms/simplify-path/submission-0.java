class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pathArray = path.split("/");
        for(String token : pathArray) {
            if(token.equals("..")) {
                if(stack.isEmpty()) continue;
                stack.pop();
                continue;
            }
            if(token.equals(".") || token.isEmpty()) continue;
            stack.push(token);
        }
        StringBuilder res = new StringBuilder();
        if(stack.isEmpty()) return "/";
        for(String directory : stack) {
            res.append("/").append(directory);
        }
        return res.toString();
    }
}