package Trees;

import java.util.*;

public class VerticalOrderTraversal {
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, PriorityQueue<NodeInfo>> columnMap = new TreeMap<>();
        Queue<QueueEntry> queue = new ArrayDeque<>();
        queue.offer(new QueueEntry(root, 0, 0));

        while (!queue.isEmpty()) {
            QueueEntry entry = queue.poll();
            TreeNode node = entry.node;
            int row = entry.row;
            int col = entry.col;
            columnMap.computeIfAbsent(col, k -> new PriorityQueue<>((a, b) -> {
                if (a.row != b.row) {
                    return Integer.compare(a.row, b.row);
                } else {
                    return Integer.compare(a.val, b.val);
                }
            })).offer(new NodeInfo(row, node.val));

            if (node.left != null) {
                queue.offer(new QueueEntry(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new QueueEntry(node.right, row + 1, col + 1));
            }
        }
        for (PriorityQueue<NodeInfo> nodeInfos : columnMap.values()) {
            List<Integer> columnList = new ArrayList<>();
            while (!nodeInfos.isEmpty()) {
                columnList.add(nodeInfos.poll().val);
            }
            ans.add(columnList);
        }

        return ans;
    }
    private static class NodeInfo {
        int row;
        int val;

        NodeInfo(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }
    private static class QueueEntry {
        TreeNode node;
        int row;
        int col;

        QueueEntry(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
