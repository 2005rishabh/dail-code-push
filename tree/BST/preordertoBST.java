
class Solution {
    int u = 0;
    public TreeNode bstFromPreorder(int[] p) {  
        return BT(p, Integer.MAX_VALUE);
    }
    public TreeNode BT(int[] p, int bound) {
        if (u == p.length || p[u] > bound) return null;

        TreeNode root = new TreeNode(p[u++]);
        root.left = BT(p, root.val);
        root.right = BT(p, bound);
        return root;
    }
}