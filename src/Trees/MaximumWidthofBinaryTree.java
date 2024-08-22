package Trees;

import Graph.ShortestBridge;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MaximumWidthofBinaryTree {
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));  // The root node is at position 0

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minPosition = queue.peek().getValue();  // Position of the first node at this level
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int currentPosition = pair.getValue() - minPosition;  // Normalize position to avoid overflow

                if (i == 0) first = currentPosition;
                if (i == size - 1) last = currentPosition;

                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * currentPosition + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * currentPosition + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;

    }
    public class Pair<K, V> {
         final K key;
         final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
           Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
