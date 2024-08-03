package LinkedList;

public class AddTwoNumbers {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode anslist=new ListNode(0);
            ListNode first=l1;
            ListNode second=l2;
            ListNode curr=anslist;
            int carry=0;

            while(first!=null||second!=null){
                int x=(first!=null)?first.val:0;
                int y=(second!=null)?second.val:0;
                int sum=x+y+carry;
                carry=sum/10;
                curr.next=new ListNode(sum%10);
                curr=curr.next;
                if(first!=null) first=first.next;
                if(second!=null) second=second.next;

            }
            if(carry>0){
                curr.next=new ListNode(carry);
            }
            return anslist.next;
        }
    }

