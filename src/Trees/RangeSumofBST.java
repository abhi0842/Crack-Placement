package Trees;

public class RangeSumofBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;}
        int sum=0;
        if(root.val>=low&&root.val<=high){
            sum+=root.val;
        }
        int left=rangeSumBST(root.left,low,high);
        int right=rangeSumBST(root.right,low,high);
        return sum+=right+left;
    }
}
