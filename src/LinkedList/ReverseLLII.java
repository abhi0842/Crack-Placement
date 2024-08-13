package LinkedList;

import java.util.List;

public class ReverseLLII {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseBetween(ListNode head, int left, int right) {
       if(left==right){
           return head;}
           ListNode curr=head;
           ListNode pre=null;
           for(int i=0;curr!=null&&i<left-1;i++){
               pre=curr;
               curr=curr.next;
           }
           ListNode last=pre;
           ListNode end=curr;
           ListNode next=curr.next;
           for(int i=0;curr!=null&&i<right-left+1;i++){
               curr.next=pre;
               pre=curr;
               curr=next;
               if(next!=null){
                   next=next.next;
               }
           }
           if(last!=null){
              last.next=pre;
           }
           else{
               head=pre;
           }
           end.next=curr;
       return head;
    }
}
