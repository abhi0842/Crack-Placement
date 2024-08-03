package LinkedList;

public class RemovefromNth {
     public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head.next==null){
                return null;
            }

            int size=0;
            ListNode curr=head;
            while(curr!=null){
                curr=curr.next;
                size++;
            }
            if(size==n){
                return head.next;
            }
            ListNode currnode=head;
            int i=1;
            int index=size-n;
            while(i<index){
                currnode =currnode.next;
                i++;
            }
            currnode.next=currnode.next.next;
            return head;


        }

    }

