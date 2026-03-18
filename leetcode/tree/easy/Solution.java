/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {

        // Used q to solve this question

        // Queue<TreeNode>  q = new LinkedList<>();
        // int c = 0;
        // if (root == null) return c;
        // q.offer(root);
        // while(!q.isEmpty()) {
        //     int s = q.size();
        //     for(int i = 0; i < s; i++) {
        //         if(q.peek().left != null) q.offer(q.peek().left);
        //         if(q.peek().right != null) q.offer(q.peek().right);
        //         q.poll();
        //     }
        //     c++;
        // }
        // return c;

        //Now using recursion
        if(root == null) return 0;
        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);

        return 1 + Math.max(ld, rd);
    }
}