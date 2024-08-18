package LinkedList;

public class zigZagList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
        public void zigzagRearrange(ListNode head) {
            if (head == null || head.next == null) return;

            boolean flag = true;

            ListNode current = head;

            while (current.next != null) {
                if (flag) {
                    if (current.val > current.next.val) {

                        int temp = current.val;
                        current.val = current.next.val;
                        current.next.val = temp;
                    }
                } else {
                    if (current.val < current.next.val) {
                        int temp = current.val;
                        current.val = current.next.val;
                        current.next.val = temp;
                    }
                }
                current = current.next;
                flag = !flag;
            }

    }
}
