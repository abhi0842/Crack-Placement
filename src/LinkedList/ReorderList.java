package LinkedList;

public class ReorderList {
     class Node{
         Node Next;
         int val;
         Node(int val) {
             this.val = val;
         }
         Node(int val, Node Next){
             this.Next=Next;
             this.val=val;
         }
     }
     public static Node  mid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.Next!=null){
            slow=slow.Next;
            fast=fast.Next.Next;
        }
        return slow;
     }
     public static Node reverse(Node head){
         if(head==null){
             return head;
         }
         Node curr=head;
         Node pre=null;
         Node next=head.Next;
         while(curr!=null){
             curr.Next=pre;
             pre=curr;
             curr=next;
            if(next!=null){
                next=next.Next;
            }
         }
         return pre;
     }
     public static void reorder(Node head){
         if(head==null&&head.Next==null){
             return;
         }
         Node mid=mid(head);
         Node sh=reverse(mid);
         Node fh=head;
         while(sh!=null&&fh!=null){
             Node temp=fh.Next;
             fh.Next=sh;
             fh=temp;
            temp =sh.Next;
            sh.Next=fh;
            sh=temp;

         }
         if(fh!=null){
             fh.Next=null;
         }

     }
}
