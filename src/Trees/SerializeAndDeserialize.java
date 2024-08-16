package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeAndDeserialize {
     public class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<String> serialize(TreeNode node){
        List<String> list=new ArrayList<>();
        helperfun(node,list);
        return list;
    }
    public List<String> helperfun(TreeNode node,List<String> list){
        if(node==null) {
            list.add("null");
            return list;

        }
        list.add(String.valueOf(node.val));
        helperfun(node.left,list);
        helperfun(node.right,list);
        return list;
    }
    public TreeNode deserialize(List<String> list){
        Collections.reverse(list);
        TreeNode node=helperfun2(list);
        return node;
    }
    public  TreeNode helperfun2(List<String> list){
        String val =list.remove(list.size()-1);
        if(val.charAt(0)=='n'){
            return null;
        }
        TreeNode node =new TreeNode(Integer.parseInt(val));
        node.left=helperfun2(list);
        node.right=helperfun2(list);
        return node;
    }
}
