package Trees;

public class SumofLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int sumOfLeftLeavesHelper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }
        return sumOfLeftLeavesHelper(node.left, true) + sumOfLeftLeavesHelper(node.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeavesHelper(root, false);
    }
}
