package Trees;

public  class LargestBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }
    static class Info {
        int size;
        int min;
        int max;
        boolean isBST;

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

        public static Info largestBSTUtil(TreeNode node) {
            // Base case: An empty tree is a BST of size 0
            if (node == null) {
                return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            }

            // Recur for left and right subtrees
            Info left = largestBSTUtil(node.left);
            Info right = largestBSTUtil(node.right);

            // Check if the current node is a BST
            if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
                // It is a BST
                int size = left.size + right.size + 1;
                return new Info(size, Math.min(left.min, node.val), Math.max(right.max, node.val), true);
            }

            // If it's not a BST, return the larger size found so far
            return new Info(Math.max(left.size, right.size), 0, 0, false);
        }

        public static int largestBSTSubtree(TreeNode root) {
            Info result = largestBSTUtil(root);
            return result.size;
        }

        public static void main(String[] args) {
            LargestBST tree = new LargestBST();

            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(5);
            root.right = new TreeNode(15);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(8);
            root.right.right = new TreeNode(7);


        }
    }