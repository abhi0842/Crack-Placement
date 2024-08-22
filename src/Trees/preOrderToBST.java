package Trees;

public class preOrderToBST {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    private int index = 0;
    public Node Bst(int pre[], int size) {
        return buildBST(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);


    }

    public  Node buildBST(int[] preorder, int min, int max) {

        if (index >= preorder.length || preorder[index] < min || preorder[index] > max) {
            return null;
        }
        int val = preorder[index++];
        Node root = new Node(val);
        root.left = buildBST(preorder, min, val);
        root.right = buildBST(preorder, val, max);

        return root;
    }
}
