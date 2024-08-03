package LinkedList;

public class PalindromicLL {
    public  class ListNode {
    int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode middleNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        ListNode Next=head.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=Next;
            if(Next!=null){
                Next=Next.next;
            }
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head){
        ListNode middle=middleNode(head);
        ListNode  secondhead =reverseList(middle);
        ListNode reverserhead=secondhead;
        while(head!=null&& secondhead!=null){
            if(head.val!=secondhead.val){
                break;
            }
            head=head.next;
            secondhead=secondhead.next;
        }
        reverseList(reverserhead);
        return (head==null||secondhead==null);

    }


}
