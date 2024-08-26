package Trees;

public class ConstructTreePreorder {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }

        private int index = 0;

        Node constructTree(int n, int pre[], char preLN[]) {
            if (index >= n) {
                return null;
            }
            Node node = new Node(pre[index]);

            if (preLN[index] == 'L') {
                index++;
                return node;
            }

            index++;
            node.left = constructTree(n, pre, preLN);
            node.right = constructTree(n, pre, preLN);

            return node;
        }

    }
}
