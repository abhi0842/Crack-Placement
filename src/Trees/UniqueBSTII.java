package Trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {
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


        public List<TreeNode> generateTrees(int n) {
            if(n==0){
                return new ArrayList<>();
            }
            return   helper(1,n);
        }
        public List<TreeNode> helper(int start,int end){
            List<TreeNode> ls=new ArrayList<>();
            if(start>end){
                ls.add(null);
                return ls;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = helper(start, i - 1);
                List<TreeNode> rightTrees = helper(i + 1, end);
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        ls.add(root);
                    }
                }
            }
            return ls;
        }
    }


