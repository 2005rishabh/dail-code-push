package binaryTreePractise;

import java.util.LinkedList;
import java.util.Queue;

public class practise {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }       
    }

    static class BinaryTree {
        static int index = -1;

        public static Node createTree(int[] arr) {
            index++;
            if (arr[index] == -1) {
                return null;
            }

            Node newNode = new Node(arr[index]);
            newNode.left = createTree(arr);
            newNode.right = createTree(arr);
            return newNode;
        }
    }

    public static void Pre(Node root) {
        if (root == null) return;

        System.out.println(root.data);
        Pre(root.left);
        Pre(root.right);
    }

    public static void In(Node root) {
        if (root == null) return;

        In(root.left);
        System.out.println(root.data);
        In(root.right);
    }

    public static int CountNodes(Node root) {
        if (root == null) return 0;
        int leftN = CountNodes(root.left);
        int rightN = CountNodes(root.right);
        return 1 + leftN + rightN;          
    }

    public static int SumOfNodes(Node root) {
        if (root == null) return 0;
        int leftSum = SumOfNodes(root.left);
        int rightSum = SumOfNodes(root.right);
        return root.data + leftSum + rightSum;
    }

    public static int Height(Node root) {
        if (root == null) return 0;
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void LevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);  // Marks end of current level

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.createTree(arr);

        System.out.println("Preorder Traversal:");
        Pre(root);

        System.out.println("Inorder Traversal:");
        In(root);

        System.out.println("Level Order Traversal:");
        LevelOrder(root);

        System.out.println("Total Nodes: " + CountNodes(root));

        System.out.println("Sum of Nodes: " + SumOfNodes(root));

        System.out.println("Height of Tree: " + Height(root));
    }
}
