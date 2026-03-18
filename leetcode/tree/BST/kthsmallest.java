
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        find(root, arr);
        return arr.get(k-1);
    }
    public void find(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) return;
        find(root.left, arr);
        arr.add(root.val);
        find(root.right, arr);
    }
}