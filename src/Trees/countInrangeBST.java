package Trees;

public class countInrangeBST {
    public class Node {
        int data;
        Node left;
       Node right;
        Node() {}
        Node(int val) { this.data = val; }
        Node(int val, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
   static int getCount(Node root,int l, int h)
    {
        if (root == null) {
            return 0;
        }
        if (root.data >= l && root.data <= h) {
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        }

        else if (root.data < l) {
            return getCount(root.right, l, h);
        }
        else {
            return getCount(root.left, l, h);
        }
    }
}
