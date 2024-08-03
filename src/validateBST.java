public class validateBST {
    public class TreeNode {
        int val;
       TreeNode left;
         TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,  TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    boolean help(TreeNode node,Integer low,Integer high){
        if(node==null){
            return true;
        }
        if(high!=null&&node.val>=high){
            return false;
        }
        if(low!=null&&node.val<=low){
            return false;
        }
        boolean left=help(node.left,low,node.val);
        boolean right=help(node.right,node.val,high);
        return left&&right;

    }

    public boolean isValidBST(TreeNode root) {
        return help(root,null,null);
    }
}

