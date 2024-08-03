package LinkedList;

public class reverseLL {
     public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head==null){
                return head;
            }
            ListNode curr=head;
            ListNode pre=null;
            ListNode Next=head.next;
            while(curr!=null){
                curr.next=pre;
                pre=curr;
                curr=Next;
                if(Next!=null){
                    Next=Next.next;
                }
            }
            return pre;
        }
    }
}
