package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergekSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;

        }

        ListNode head=new ListNode(0);
        ListNode temp=head;
        ArrayList<Integer> li=new ArrayList<>();
        for(ListNode list:lists){
            while( list!=null){
                li.add(list.val);
                list=list.next;
            }
        }
        Collections.sort(li);
        for(int val:li){
            temp.next=new ListNode(val);
            temp=temp.next;

        }
        return head.next;

    }
}
