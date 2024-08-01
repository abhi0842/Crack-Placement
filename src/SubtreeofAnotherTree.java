public class SubtreeofAnotherTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean same(TreeNode s,TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }

        if(s.val!=t.val){
            return false;
        }
        return same(s.left,t.left)&&same(s.right,t.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root== null){
            return false;
        }
        if(same(root,subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot)||same(root.right,subRoot);
    }
}
