package Trees;

public class MedianTree {

    class Node {
        int data;
        Node left, right;
        Node(int x) {
            data = x;
            left = right = null;
        }
    }


        int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

        void findMedianUtil(Node root, int count, float[] currentCount, Node[] previousNode, Node[] medianNodes) {
            if (root == null) {
                return;
            }

            findMedianUtil(root.left, count, currentCount, previousNode, medianNodes);

            currentCount[0]++;
            if (count % 2 != 0) { // Odd case
                if (currentCount[0] == (count + 1) / 2) {
                    medianNodes[0] = root;
                    return;
                }
            } else { // Even case
                if (currentCount[0] == count / 2) {
                    medianNodes[0] = root;
                }
                if (currentCount[0] == count / 2 + 1) {
                    medianNodes[1] = root;
                    return;
                }
            }

            findMedianUtil(root.right, count, currentCount, previousNode, medianNodes);
        }

        float findMedian(Node root) {
            int count = countNodes(root);
            float[] currentCount = {0};
            Node[] medianNodes = new Node[2];

            findMedianUtil(root, count, currentCount, new Node[1], medianNodes);

            if (count % 2 != 0) {
                return (float) medianNodes[0].data;
            } else {
                return ((float) medianNodes[0].data + medianNodes[1].data) / 2;
            }
        }

    }

