package Trees;

public class minimumabsBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Integer pre=null;
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return min;
        }
        getMinimumDifference(root.left);
        if(pre!=null){
            min=Math.min(min,root.val-pre);
        }
        if(root!=null){
            pre=root.val;
        }
        getMinimumDifference(root.right);
        return min;
    }
}
