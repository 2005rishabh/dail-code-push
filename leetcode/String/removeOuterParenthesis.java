class Solution {
    public String removeOuterParentheses(String s) {
        String result = "";
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0) result += c;
                count++;
            } else {
                count--;
                if (count > 0) result += c;
            }
        }
        return result;
    }
}