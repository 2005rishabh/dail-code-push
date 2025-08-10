class Solution {
    public static List<String> generateBinaryStrings(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, new StringBuilder(), res);
        return res;
    }
    
    private static void dfs(int n, StringBuilder sb, List<String> res) {
        if (sb.length() == n) {              
            res.add(sb.toString());             
            return;
        }
    
        sb.append('0');
        dfs(n, sb, res);
        sb.setLength(sb.length() - 1);
    
        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '1') {
            sb.append('1');
            dfs(n, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }
}
