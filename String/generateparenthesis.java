class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), r);
        return r;
    }

    private void dfs(int n, int open, int close, StringBuilder sb, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) { 
            sb.append('(');
            dfs(n, open + 1, close, sb, res);
            sb.setLength(sb.length() - 1);
        }

        if (close < open) { 
            sb.append(')');
            dfs(n, open, close + 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }

}
