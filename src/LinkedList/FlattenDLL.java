package LinkedList;


import java.util.Stack;
public class FlattenDLL {
class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
    }
        public static Node flatten(Node head) {
            if (head == null) {
                return null;
            }

            Node current = head;
            Node tail = head;  // Tail keeps track of the end of the flattened list
            Stack<Node> stack = new Stack<>();

            while (current != null) {
                // If the current node has a child, we'll need to flatten it
                if (current.child != null) {
                    if (current.next != null) {
                        stack.push(current.next); // Save the next node for later
                    }
                    // Flatten the child list
                    current.next = current.child;
                    current.child.prev = current;
                    current.child = null; // Don't forget to nullify the child pointer
                }

                tail = current; // Move tail to the current node
                current = current.next;

                // If we reach the end of the current list and there are nodes left in the stack
                if (current == null && !stack.isEmpty()) {
                    current = stack.pop();
                    tail.next = current;
                    current.prev = tail;
                }
            }

            return head;
        }

        // Function to print the flattened doubly linked list
        public static void printList(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Create a sample multilevel doubly linked list

//            Node head = new Node(1);
//            head.next = new Node(2);
//            head.next.prev = head;
//            head.next.next = new Node(3);
//            head.next.next.prev = head.next;
//            head.next.next.next = new Node(4);
//            head.next.next.next.prev = head.next.next;
//
//            // Add child to node 2
//            head.next.child = new Node(5);
//            head.next.child.next = new Node(6);
//            head.next.child.next.prev = head.next.child;
//
//            // Add child to node 3
//            head.next.next.child = new Node(7);
//            head.next.next.child.child = new Node(8);
//

        }
    }

