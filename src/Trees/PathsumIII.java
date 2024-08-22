package Trees;

import java.util.HashMap;
import java.util.Map;

public class PathsumIII {
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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0, targetSum, map);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> map) {
        if (node == null) {
            return 0;
        }
        currentSum += node.val;
        int count = map.getOrDefault(currentSum - targetSum, 0);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        int left = dfs(node.left, currentSum, targetSum, map);
        int right = dfs(node.right, currentSum, targetSum, map);

        int paths = count + left + right;
        map.put(currentSum, map.get(currentSum) - 1);

        return paths;
    }
}
