class Solution {
    public boolean rotateString(String a, String b) {
        return (a.length() == b.length() && (a+a).contains(b));
    }
}