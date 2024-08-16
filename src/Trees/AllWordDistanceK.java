package Trees;

import java.util.*;

public class AllWordDistanceK {
     public class TreeNode {
    int val;     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    private void addParent(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            addParent(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            addParent(root.right);
        }
    }
    private void collectKDistanceNodes(TreeNode target, int k, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            if (k == 0) {
                break;
            }

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                }

                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    queue.add(parentMap.get(current));
                    visited.add(parentMap.get(current));
                }
            }
            k--;
        }

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        addParent(root);
        collectKDistanceNodes(target, k, result);
        return result;
    }
}
