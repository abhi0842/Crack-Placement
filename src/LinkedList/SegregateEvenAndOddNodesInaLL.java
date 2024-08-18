package LinkedList;

public class SegregateEvenAndOddNodesInaLL {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


        public static ListNode segregateEvenOdd(ListNode head) {
            if (head == null) return null;

            ListNode evenHead = null, evenTail = null;
            ListNode oddHead = null, oddTail = null;

            ListNode current = head;

            while (current != null) {
                if (current.val % 2 == 0) {
                    if (evenHead == null) {
                        evenHead = evenTail = current;
                    } else {
                        evenTail.next = current;
                        evenTail = evenTail.next;
                    }
                } else {
                    if (oddHead == null) {
                        oddHead = oddTail = current;
                    } else {
                        oddTail.next = current;
                        oddTail = oddTail.next;
                    }
                }
                current = current.next;
            }
            if (evenHead == null) return oddHead;
            evenTail.next = oddHead;

            if (oddTail != null) oddTail.next = null;

            return evenHead;
        }

}
