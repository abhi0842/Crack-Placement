package LinkedList;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MultiplyLLNode {
    Node head;

    // Method to append a new node at the end
    void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    // Method to convert linked list to a number
    long linkedListToNumber() {
        long number = 0;
        Node current = head;
        while (current != null) {
            number = (number * 10 + current.data) % 1000000007;
            current = current.next;
        }
        return number;
    }

    // Method to multiply two linked lists
    static long multiplyTwoLists(MultiplyLLNode l1, MultiplyLLNode l2) {
        long num1 = l1.linkedListToNumber();
        long num2 = l2.linkedListToNumber();
        return (num1 * num2) % 1000000007;
    }

    // Method to print the linked list
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MultiplyLLNode l1 = new MultiplyLLNode();
        l1.append(1);
        l1.append(2);
        l1.append(3);

        MultiplyLLNode l2 = new MultiplyLLNode();
        l2.append(4);
        l2.append(5);
        l2.append(6);

        System.out.println("List 1:");
        l1.printList();

        System.out.println("List 2:");
        l2.printList();

        long result = multiplyTwoLists(l1, l2);
        System.out.println("Result: " + result);
    }
}