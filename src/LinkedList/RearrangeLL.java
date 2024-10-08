package LinkedList;

public class RearrangeLL {
    static Node reverseList(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static Node rearrange(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node firstHalf = node;
        Node secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverseList(secondHalf);
        Node dummy = new Node(0);
        Node curr = dummy;
        while (firstHalf != null || secondHalf != null) {
            if (firstHalf != null) {
                curr.next = firstHalf;
                curr = curr.next;
                firstHalf = firstHalf.next;
            }
            if (secondHalf != null) {
                curr.next = secondHalf;
                curr = curr.next;
                secondHalf = secondHalf.next;
            }
        }

        return dummy.next;
    }
}
