import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
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


        public void helper(TreeNode root, String s, List<String> path){
            if(root.left==null&&root.right==null){
                path.add(s+root.val);
                return;
            }
            if(root.left!=null){
                helper(root.left, s + root.val + "->", path);
            }
            if(root.right!=null){
                helper(root.right, s + root.val + "->", path);
            }
        }
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> path=new ArrayList<>();

            if(root==null){
                return path;
            }
            helper(root,"",path);
            return path;

        }
    }

