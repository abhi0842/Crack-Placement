package LinkedList;

public class ReverseKNodes {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, Node Next){
            this.next=next;
            this.val=val;
        }
    }
    public static int sizeofList(ListNode head)
    {
        int size=0;
        while(head!=null)
        {
            head=head.next;
            size++;
        }
        return size;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr=head;
        ListNode prev=null;
        ListNode Next=curr;
        int count=0;
        int size=0;





        if(sizeofList(head)<k && Next!=null)
        {

            return Next;
        }
        else
        {
            while(curr!=null && count<k )
            {
                Next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=Next;
                count++;
            }
            if(Next!=null)
                head.next=reverseKGroup(Next,k);
        }
        return prev;


    }
}
