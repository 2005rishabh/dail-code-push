import java.util.*;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); // Fix: use i, not [i]
        }
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] pre, int ps, int pe,
                           int[] in, int is, int ie,
                           Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(pre[ps]);
        int inRootIndex = map.get(root.val);
        int numsLeft = inRootIndex - is;

        root.left = build(pre, ps + 1, ps + numsLeft,
                          in, is, inRootIndex - 1, map);
        root.right = build(pre, ps + numsLeft + 1, pe,
                           in, inRootIndex + 1, ie, map);

        return root;
    }
}
