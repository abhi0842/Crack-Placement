public class TreeDiameter {
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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int heightleft=height(root.left);
        int heightright=height(root.right);
        int dia= heightleft+heightright+1;
        diameter=Math.max(diameter,dia);
        return Math.max(heightleft,heightright)+1;

    }

    public static void main(String[] args) {

    }
}
