class Solution {
    int d = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return d;
    }

    private int maxSum(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));

        // Update max path sum using current node as root of the path
        d = Math.max(d, root.val + left + right);

        // Return max one-side path to parent
        return root.val + Math.max(left, right);
    }
}
