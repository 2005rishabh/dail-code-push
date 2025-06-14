package binaryTreePractise;

public class practise {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }       
    }

    static class binaryTree{
        static int x = -1;
        public static Node createTree(int[] arr) {
            x++;
            if(arr[x] == -1){
                return null;
            }
            Node newNode = new Node(arr[x]);
            newNode.left = createTree(arr);
            newNode.right = createTree(arr);
            return newNode;
        }
    }
    public static void Pre(Node head) {
        if(head == null) {
            return;
        }
        System.out.println(head.data);
        Pre(head.left);
        Pre(head.right);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        binaryTree tree = new binaryTree();
        Node root = tree.createTree(arr);
        Pre(root);
    }
}