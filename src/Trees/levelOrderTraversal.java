package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){

            List<Integer> curr=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode currnode=q.poll();
                curr.add(currnode.val);
                if(currnode.left!=null){
                    q.offer(currnode.left);

                }
                if(currnode.right!=null){
                    q.offer(currnode.right);
                }
            }
            res.add(curr);
        }
        return res;
    }
}
