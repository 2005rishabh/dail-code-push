class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = s.replaceAll("[^a-z0-9]", ""); 
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
