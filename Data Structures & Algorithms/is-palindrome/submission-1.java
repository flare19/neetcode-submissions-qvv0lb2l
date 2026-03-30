class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        List<Character> chrarr = new ArrayList<>();
        for (char c : str.toCharArray()) {
            chrarr.add(c);
        }
        List<Character> revarr = new ArrayList<>();

        for(int i = chrarr.size() - 1; i >= 0; i--) {
            revarr.add(chrarr.get(i));
        }

        return chrarr.equals(revarr);
    }
}
