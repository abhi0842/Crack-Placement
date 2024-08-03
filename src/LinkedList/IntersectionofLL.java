package LinkedList;

public class IntersectionofLL {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public int length(ListNode head){
        if(head==null){
            return 0;
        }
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        return size;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode tempA=headA;
        ListNode tempB=headB;

        int A=length(tempA);
        int B=length(tempB);
        if(A>B){
            int templength=A-B;
            while(templength!=0){
                tempA=tempA.next;
                templength--;
            }
        }
        else{
            int templength=B-A;
            while(templength!=0){
                tempB=tempB.next;
                templength--;
            }
        }

        while(tempA!=null||tempB!=null){
            if(tempA==tempB){
                return tempA;
            }
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
}
