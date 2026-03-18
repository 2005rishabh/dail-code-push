import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class BoundaryTraversal {
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.val);

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);

        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    private void addLeaves(TreeNode node, List<Integer> res) {
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        if (node.left != null) addLeaves(node.left, res);
        if (node.right != null) addLeaves(node.right, res);
    }

    // Sample tree to test
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
                 \   \
                  7   8
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        BoundaryTraversal bt = new BoundaryTraversal();
        List<Integer> boundary = bt.boundaryOfBinaryTree(root);

        System.out.println("Boundary Traversal: " + boundary);
    }
}
