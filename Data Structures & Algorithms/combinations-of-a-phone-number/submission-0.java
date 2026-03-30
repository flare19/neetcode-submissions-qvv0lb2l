class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        String[] charSet = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder part = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(0, digits, charSet, part, res);
        return res;
    }

    private void dfs(int i, String digits, String[] charSet, StringBuilder part, List<String> res) {
        if(i >= digits.length()) {
            res.add(part.toString());
            return;
        }
        int digit = digits.charAt(i) - '0';
        for(int j=0; j<charSet[digit].length(); j++) {
            part.append(charSet[digit].charAt(j));
            dfs(i+1, digits, charSet, part, res);
            part.deleteCharAt(part.length() - 1);
        }
    } 
}
