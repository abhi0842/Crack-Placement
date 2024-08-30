package LinkedList;



class flattenLL {
    class Node {
        int data;
      Node next;
     Node bottom;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }
    // Function to merge two sorted linked lists
    Node mergeTwoLists(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = mergeTwoLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeTwoLists(a, b.bottom);
        }

        result.next = null;  // Ensure the next pointer is null for the flattened list
        return result;
    }

    // Function to flatten the linked list
    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        // Recur for the list on the right
        root.next = flatten(root.next);

        // Merge the current list with the flattened list from the right
        root = mergeTwoLists(root, root.next);

        return root;
    }

    // Utility function to print the flattened linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
    }

    public static void main(String[] args) {
//        Node L = new Node();
//
//        Node root = new Node(5);
//        root.next = new Node(10);
//        root.next.next = new Node(19);
//        root.next.next.next = new Node(28);
//
//        root.bottom = new Node(7);
//        root.bottom.bottom = new Node(8);
//        root.bottom.bottom.bottom = new Node(30);
//
//        root.next.bottom = new Node(20);
//
//        root.next.next.bottom = new Node(22);
//        root.next.next.bottom.bottom = new Node(50);
//
//        root.next.next.next.bottom = new Node(35);
//        root.next.next.next.bottom.bottom = new Node(40);
//        root.next.next.next.bottom.bottom.bottom = new Node(45);
//
//        // Flatten the list
//        root = L.flatten(root);
//
//        // Print the flattened list
//        L.printList(root);
    }}
