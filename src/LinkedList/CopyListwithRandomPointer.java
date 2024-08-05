package LinkedList;

import java.util.HashMap;

public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr!=null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        //The next pointer of the corresponding cloned node (map.get(curr))
        //is set to the clone of the node that curr.next points to (map.get(curr.next)).
        //Similarly, the random pointer of the cloned node
// is set to the clone of the node that curr.random points to (map.get(curr.random)).
        curr = head;

        while(curr!=null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);


    }
}
