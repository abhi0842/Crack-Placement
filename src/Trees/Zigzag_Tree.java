package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Zigzag_Tree {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        boolean reverse=false;
        queue.offer(root);
        while(!queue.isEmpty()){

            List<Integer> currlist=new ArrayList<>();
            int level=queue.size();
            for(int i=0;i<level;i++){
                if(!reverse){
                    TreeNode currnode=queue.pollFirst();
                    currlist.add(currnode.val);
                    if(currnode.left!=null){
                        queue.addLast(currnode.left);
                    }
                    if(currnode.right!=null){
                        queue.addLast(currnode.right);
                    }
                }
                else{
                    TreeNode currnode=queue.pollLast();
                    currlist.add(currnode.val);

                    if(currnode.right!=null){
                        queue.addFirst(currnode.right);
                    }
                    if(currnode.left!=null){
                        queue.addFirst(currnode.left);
                    }
                }
            }
            reverse=!reverse;


            result.add(currlist);
        }
        return result;
    }
}
